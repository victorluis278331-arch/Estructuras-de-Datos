package arbolgenealogico;

import implementaciones.BinaryTree;
import java.util.Iterator;
import modelo.Familiar;


public class Main {

    public static void main(String[] args) {

        // ----- Bisabuelos (hojas) -----
        BinaryTree<Familiar> bisabuelo1 = new BinaryTree<>(
                new Familiar("Bisabuelo paterno antonio", 90, "Agricultor", true, "San Miguel, Oaxaca"));
        BinaryTree<Familiar> bisabuela1 = new BinaryTree<>(
                new Familiar("Bisabuela paterna JOSEFINA", 88, "Ama de casa", true, "San Miguel, Oaxaca"));

        // ----- Abuelos -----
        BinaryTree<Familiar> abueloPaterno = new BinaryTree<>(
                new Familiar("Abuelo paterno : urbano", 72, "Comerciante", true, "San Miguel, Oaxaca"),
                bisabuelo1, bisabuela1);
        BinaryTree<Familiar> abuelaPaterna = new BinaryTree<>(
                new Familiar("Abuela paterna: maxima ", 65, "Ama de casa", false, "San Miguel, Oaxaca"));
        BinaryTree<Familiar> abueloMaterno = new BinaryTree<>(
                new Familiar("Abuelo materno: isaias ", 75, "ARQUITECTO", false, "San Miguel, Oaxaca"));
        BinaryTree<Familiar> abuelaMaterna = new BinaryTree<>(
                new Familiar("Abuela materna: julia", 63, "Maestra", false, "San Miguel, Oaxaca"));

        // ----- Padres -----
        BinaryTree<Familiar> padre = new BinaryTree<>(
                new Familiar("Padre", 40, "comerciante", true, "San Miguel, Oaxaca"),
                abueloPaterno, abuelaPaterna);
        BinaryTree<Familiar> madre = new BinaryTree<>(
                new Familiar("Madre", 41, "comerciate", false, "San Miguel, Oaxaca"),
                abueloMaterno, abuelaMaterna);

        // ----- Yo -----
        BinaryTree<Familiar> arbol = new BinaryTree<>(
                new Familiar("Víctor Isaac Luis Luis", 20, "Estudiante", false, "San Miguel, Oaxaca"),
                padre, madre);

   
        System.out.println("===== ÁRBOL GENEALÓGICO =====");
        System.out.println("Raíz: " + arbol.getRootData());
        System.out.println("Altura (generaciones): " + arbol.getHeight());
        System.out.println("Número de familiares: " + arbol.getNumberNodes());

        System.out.println("\n--- Recorrido en PREORDEN (raíz, izq, der) ---");
        imprimir(arbol.getPreorderIterator());

        System.out.println("\n--- Recorrido en POSTORDEN (izq, der, raíz) ---");
        imprimir(arbol.getPostorderIterator());

        System.out.println("\n--- Recorrido en ORDEN (izq, raíz, der) ---");
        imprimir(arbol.getInorderIterator());
    }

    private static void imprimir(Iterator<Familiar> iter) {
        int n = 1;
        while (iter.hasNext()) {
            System.out.println(n++ + ". " + iter.next());
        }
    }
}
