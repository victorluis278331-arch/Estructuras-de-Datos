package recursividad;

import java.util.Arrays;

public class PruebaRecursividad {

    public static void main(String[] args) {
        // 1. Fibonacci de 5
        System.out.println("Fibonacci de 5: " + Recursividad.fibonacci(5));

        // 2. Fibonacci de 40
        System.out.println("Fibonacci de 40: " + Recursividad.fibonacci(40));

        // 3. MCD de 45 y 75
        System.out.println("MCD de 45 y 75: " + Recursividad.mcd(45, 75));

        // 4. MCD de 47 y 91
        System.out.println("MCD de 47 y 91: " + Recursividad.mcd(47, 91));

        // Definición de arreglos de prueba (usando tipos envolventes Object[])
        Object[] numeros = {1, 2, 3, 3, 2, 3, 1};
        Object[] letras = {'A', 'B', 'C', 'B', 'A', 'B', 'D'};

        // 5. Ocurrencias de 3 en [1, 2, 3, 3, 2, 3, 1]
        System.out.println("Ocurrencias de 3: " + Recursividad.count(numeros, numeros.length, 3));

        // 6. Ocurrencias de 1 en [1, 2, 3, 3, 2, 3, 1]
        System.out.println("Ocurrencias de 1: " + Recursividad.count(numeros, numeros.length, 1));

        // 7. Ocurrencias de 'C' en ['A', 'B', 'C', 'B', 'A', 'B', 'D']
        System.out.println("Ocurrencias de 'C': " + Recursividad.count(letras, letras.length, 'C'));

        // 8. Ocurrencias de 'E' en ['A', 'B', 'C', 'B', 'A', 'B', 'D']
        System.out.println("Ocurrencias de 'E': " + Recursividad.count(letras, letras.length, 'E'));

        // 9. Invertir arreglo [1, 2, 3, 4, 5]
        Object[] arrNum = {1, 2, 3, 4, 5};
        Recursividad.reverse(arrNum, 0, arrNum.length - 1);
        System.out.println("Arreglo numérico invertido: " + Arrays.toString(arrNum));

        // 10. Invertir arreglo ['A', 'B', 'C', 'D']
        Object[] arrLetras = {'A', 'B', 'C', 'D'};
        Recursividad.reverse(arrLetras, 0, arrLetras.length - 1);
        System.out.println("Arreglo de caracteres invertido: " + Arrays.toString(arrLetras));
    }
}