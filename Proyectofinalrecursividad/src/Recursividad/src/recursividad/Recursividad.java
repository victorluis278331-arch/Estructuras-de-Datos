package recursividad;

import java.util.Objects;

public class Recursividad {

    // 1. Fibonacci n-ésimo
    public static long fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // 2. Máximo Común Divisor (Algoritmo de Euclides)
    public static int mcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return mcd(b, a % b);
    }

    // 3. Conteo de ocurrencias de un objeto en un arreglo
    public static int count(Object datos[], int n, Object o) {
        if (n <= 0) {
            return 0;
        }
        int coincide = Objects.equals(datos[n - 1], o) ? 1 : 0;
        return coincide + count(datos, n - 1, o);
    }

    // 4. Inversión de elementos en un arreglo
    public static void reverse(Object datos[], int inicio, int fin) {
        if (inicio >= fin) {
            return;
        }
        Object temp = datos[inicio];
        datos[inicio] = datos[fin];
        datos[fin] = temp;

        reverse(datos, inicio + 1, fin - 1);
    }
}