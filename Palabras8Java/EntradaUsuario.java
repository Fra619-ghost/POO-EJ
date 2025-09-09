package Palabras8Java;


import java.util.Scanner;

public class EntradaUsuario {
    private Scanner sc;

    public EntradaUsuario() {
        sc = new Scanner(System.in);
    }

    // Pide un número positivo de palabras
    public int pedirCantidad() {
        int contador = 0;
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
        return contador;
    }

    // Pide las palabras con validación
    public String[] pedirPalabras(int cantidad) {
        String[] palabras = new String[cantidad];
        for (int i = 0; i < cantidad; i++) {
            String palabra;
            do {
                System.out.print("Digite la palabra " + (i + 1) + ": ");
                palabra = sc.nextLine().trim();
                if (palabra.isEmpty()) {
                    System.out.println("No se permite palabra vacía, intente de nuevo.");
                }
            } while (palabra.isEmpty());
            palabras[i] = palabra;
        }
        return palabras;
    }
}
