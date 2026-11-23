package implementaciones;

import interfaces.ITree;


public class BinaryTreeComun<T> implements ITree<T> {

    protected NodoArbolBinario<T> raiz;

    protected static class NodoArbolBinario<E> {
        E dato;
        NodoArbolBinario<E> hijoIzq;
        NodoArbolBinario<E> hijoDer;

        public NodoArbolBinario(E dato) {
            this.dato = dato;
        }
    }

    @Override
    public T getRootData() {
        if (raiz == null) {
            return null;
        }
        return raiz.dato;
    }

    @Override
    public int getHeight() {
        return getHeight(raiz);
    }

    protected int getHeight(NodoArbolBinario<T> nodo) {
        int height = 0;
        if (nodo != null) {
            height = 1 + Math.max(getHeight(nodo.hijoIzq),
                                  getHeight(nodo.hijoDer));
        }
        return height;
    }

    @Override
    public int getNumberNodes() {
        return getNumberNodes(raiz);
    }

    private int getNumberNodes(NodoArbolBinario<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + getNumberNodes(nodo.hijoIzq) + getNumberNodes(nodo.hijoDer);
    }

    @Override
    public boolean empty() {
        return raiz == null;
    }

    @Override
    public void clear() {
        raiz = null;
    }
}
