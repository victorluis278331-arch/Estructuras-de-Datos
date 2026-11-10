/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectofinalrecursividad;

/**
 *
 * @author isaac
 */
import java.util.Scanner;

public class proyectofinalrecursividad {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe una expresión (deja vacio y da entyer para salir):");
        pedirExpresion(sc);
        sc.close();
    }

    public static int evaluar(String s) {
        if (s == null) {
            throw new IllegalArgumentException("La cadena es nula");
        }
        s = s.trim();
        if (s.isEmpty()) {
            throw new IllegalArgumentException("Operando vacio");
        }

        //apluica la ley jeraquica
        int i = buscarOperador(s, s.length() - 1, 0, "+-");
        if (i == -1) {
            i = buscarOperador(s, s.length() - 1, 0, "*");
        }

        if (i != -1) {
            int izq = evaluar(s.substring(0, i));      // llamada recursiva
            int der = evaluar(s.substring(i + 1));     // llamada recursiva
            switch (s.charAt(i)) {
                case '+': return izq + der;
                case '-': return izq - der;
                default:  return izq * der;
            }
        }

        // quita el exeso dee paretesis
        if (s.charAt(0) == '(' && s.charAt(s.length() - 1) == ')') {
            return evaluar(s.substring(1, s.length() - 1));   // llamada recursiva
        }
        if (esNumero(s)) {
            return Integer.parseInt(s);
        }
        throw new IllegalArgumentException("Formato inválido: \"" + s + "\"");
    }

    // recorre la cadena de derecha a izquierda (recursivamente) y regresa el
    // indice del ultimo operador de 'ops' que esté fuera de paréntesis; -1 si no hay.
    private static int buscarOperador(String s, int i, int nivel, String ops) {
        if (i < 0) {
            if (nivel != 0) {
                throw new IllegalArgumentException("Paréntesis mal balanceados");
            }
            return -1;
        }
        char c = s.charAt(i);
        if (c == ')') {
            nivel++;
        } else if (c == '(') {
            nivel--;
            if (nivel < 0) {
                throw new IllegalArgumentException("Paréntesis mal balanceados");
            }
        } else if (nivel == 0 && ops.indexOf(c) >= 0) {
            return i;
        }
        return buscarOperador(s, i - 1, nivel, ops);
    }

    // Verifica recursivamente que la cadena sean solo digitos
    private static boolean esNumero(String s) {
        if (s.isEmpty()) {
            return false;
        }
        char c = s.charAt(0);
        boolean digito = c >= '0' && c <= '9';
        if (s.length() == 1) {
            return digito;
        }
        return digito && esNumero(s.substring(1));
    }

    // Pide expresiones al usuario d
    private static void pedirExpresion(Scanner sc) {
        System.out.print("> ");
        String entrada = sc.nextLine();
        if (entrada.trim().isEmpty()) {
            return;   // caso base: iínea vacía termina
        }
        try {
            System.out.println("Resultado: " + evaluar(entrada));
        } catch (IllegalArgumentException ex) {
            System.out.println("Excepción: " + ex.getMessage());
        }
        pedirExpresion(sc);   // llamada recursiva
    }

  
}

