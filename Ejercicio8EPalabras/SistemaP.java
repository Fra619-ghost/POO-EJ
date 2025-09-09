// Realizar un programa con arreglo de strings y metodos para:
//Contra cuantas palabras hay
// Palabras unicas
// Palabras mas largas y cortas


package Ejercicio8EPalabras;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

// Clase para procesar las palabras ingresadas
class Palabras {
    String[] palabras; // Arreglo que almacena todas las palabras

    // Constructor que recibe un arreglo de palabras
    Palabras(String[] palabras) {
        this.palabras = palabras;
    }

    // Contar cuántas palabras hay
    public void contarPalabras() {
        System.out.println("Cantidad total de palabras: " + palabras.length);
    }

    // Mostrar palabras únicas (sin repetición)
    public void palabrasUnicas() {
        Set<String> unicas = new HashSet<>(); // HashSet elimina duplicados
        for (String palabra : palabras) {
            unicas.add(palabra);
        }
        System.out.println("Palabras únicas: " + unicas);
    }

    // Mostrar la palabra más corta
    public void palabrasMasCorta() {
        if (palabras.length == 0) {
            System.out.println("No hay palabras para analizar.");
            return;
        }

        String masCorta = palabras[0];
        for (String palabra : palabras) {
            if (palabra.length() < masCorta.length()) {
                masCorta = palabra;
            }
        }
        System.out.println("Palabra más corta: " + masCorta);
    }

    // Mostrar la palabra más larga
    public void palabrasMasLarga() {
        if (palabras.length == 0) {
            System.out.println("No hay palabras para analizar.");
            return;
        }

        String masLarga = palabras[0];
        for (String palabra : palabras) {
            if (palabra.length() > masLarga.length()) {
                masLarga = palabra;
            }
        }
        System.out.println("Palabra más larga: " + masLarga);
    }


    public void mostrarResultados() {
        contarPalabras();
        palabrasUnicas();
        palabrasMasCorta();
        palabrasMasLarga();
    }
}

// Clase principal q gestiona la interaccion con el usuario
public class SistemaP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int contador = 0;

        // Validación para que el número de palabras sea positivo
        do {
            System.out.print("Digite el número de palabras (mayor a 0): ");
            if (sc.hasNextInt()) {
                contador = sc.nextInt();
                if (contador <= 0) {
                    System.out.println("Debe ingresar un número positivo.");
                }
            } else {
                System.out.println("Debe ingresar un número entero.");
                sc.next(); // limpiar entrada incorrecta
            }
        } while (contador <= 0);

        sc.nextLine(); // limpiar buffer

        String[] palabras = new String[contador];

        // Ingreso de palabras con validación
        for (int i = 0; i < contador; i++) {
            String palabra;
            do {
                System.out.print("Digite la palabra " + (i + 1) + ": ");
                palabra = sc.nextLine().trim(); // elimina espacios al inicio y fin
                if (palabra.isEmpty()) {
                    System.out.println("No se permite palabra vacía, intente de nuevo.");
                }
            } while (palabra.isEmpty());
            palabras[i] = palabra;
        }

        // Crear objeto y mostrar resultados
        Palabras est = new Palabras(palabras);
        est.mostrarResultados();
    }
}


