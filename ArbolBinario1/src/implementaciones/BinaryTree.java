package implementaciones;

import interfaces.ITreeIterator;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class BinaryTree<T> extends BinaryTreeComun<T> implements ITreeIterator<T> {

    class InorderIterator implements Iterator<T> {
        private final Deque<NodoArbolBinario<T>> pilaNodos = new ArrayDeque<>();

        public InorderIterator() {
            pushSubArbolIzquierdo(raiz);
        }

        private void pushSubArbolIzquierdo(NodoArbolBinario<T> nodo) {
            while (nodo != null) {
                pilaNodos.push(nodo);
                nodo = nodo.hijoIzq;
            }
        }

        @Override
        public boolean hasNext() {
            return !pilaNodos.isEmpty();
        }

        @Override
        public T next() {
            if (pilaNodos.isEmpty()) {
                throw new NoSuchElementException();
            }
            NodoArbolBinario<T> nodoSig = pilaNodos.pop();
            pushSubArbolIzquierdo(nodoSig.hijoDer);
            return nodoSig.dato;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /** Recorrido en preorden: raíz, izquierdo, derecho */
    class PreorderIterator implements Iterator<T> {
        private final Deque<NodoArbolBinario<T>> pilaNodos = new ArrayDeque<>();

        public PreorderIterator() {
            if (raiz != null) {
                pilaNodos.push(raiz);
            }
        }

        @Override
        public boolean hasNext() {
            return !pilaNodos.isEmpty();
        }

        @Override
        public T next() {
            if (pilaNodos.isEmpty()) {
                throw new NoSuchElementException();
            }
            NodoArbolBinario<T> nodo = pilaNodos.pop();
            // Se mete primero el derecho para que el izquierdo salga antes
            if (nodo.hijoDer != null) {
                pilaNodos.push(nodo.hijoDer);
            }
            if (nodo.hijoIzq != null) {
                pilaNodos.push(nodo.hijoIzq);
            }
            return nodo.dato;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /** Recorrido en postorden: izquierdo, derecho, raíz */
    class PostorderIterator implements Iterator<T> {
        private final Deque<NodoArbolBinario<T>> resultado = new ArrayDeque<>();

        public PostorderIterator() {
            // Se recorre raíz-derecho-izquierdo y se guarda en una pila;
            // al sacar los nodos de ella salen en izquierdo-derecho-raíz.
            Deque<NodoArbolBinario<T>> temporal = new ArrayDeque<>();
            if (raiz != null) {
                temporal.push(raiz);
            }
            while (!temporal.isEmpty()) {
                NodoArbolBinario<T> nodo = temporal.pop();
                resultado.push(nodo);
                if (nodo.hijoIzq != null) {
                    temporal.push(nodo.hijoIzq);
                }
                if (nodo.hijoDer != null) {
                    temporal.push(nodo.hijoDer);
                }
            }
        }

        @Override
        public boolean hasNext() {
            return !resultado.isEmpty();
        }

        @Override
        public T next() {
            if (resultado.isEmpty()) {
                throw new NoSuchElementException();
            }
            return resultado.pop().dato;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

   
    public BinaryTree() {
        raiz = null;
    }

    /** Crea un arbol binario con un solo nodo */
    public BinaryTree(T datoRaiz) {
        raiz = new NodoArbolBinario<>(datoRaiz);
    }

 
    public BinaryTree(T datoRaiz, BinaryTree<T> arbolIzq, BinaryTree<T> arbolDer) {
        setTree(datoRaiz, arbolIzq, arbolDer);
    }

    private void setTree(T datoRaiz, BinaryTree<T> arbolIzq, BinaryTree<T> arbolDer) {
        raiz = new NodoArbolBinario<>(datoRaiz);
        if ((arbolIzq != null) && !arbolIzq.empty()) {
            raiz.hijoIzq = copy(arbolIzq.raiz);
        }
        if ((arbolDer != null) && !arbolDer.empty()) {
            raiz.hijoDer = copy(arbolDer.raiz);
        }
    }

    
    private NodoArbolBinario<T> copy(NodoArbolBinario<T> nodo) {
        NodoArbolBinario<T> nuevoNodo = new NodoArbolBinario<>(nodo.dato);
        if (nodo.hijoIzq != null) {
            nuevoNodo.hijoIzq = copy(nodo.hijoIzq);
        }
        if (nodo.hijoDer != null) {
            nuevoNodo.hijoDer = copy(nodo.hijoDer);
        }
        return nuevoNodo;
    }

 
    @Override
    public Iterator<T> getInorderIterator() {
        return new InorderIterator();
    }

    @Override
    public Iterator<T> getPreorderIterator() {
        return new PreorderIterator();
    }

    @Override
    public Iterator<T> getPostorderIterator() {
        return new PostorderIterator();
    }

    

    private String armarCadena(Iterator<T> iter) {
        String s = "[";
        if (iter.hasNext()) {
            s += iter.next();
            while (iter.hasNext()) {
                s += ", " + iter.next();
            }
        }
        return s + "]";
    }

    public String toStringInOrder() {
        return armarCadena(getInorderIterator());
    }

    public String toStringPreOrder() {
        return armarCadena(getPreorderIterator());
    }

    public String toStringPostOrder() {
        return armarCadena(getPostorderIterator());
    }
}
