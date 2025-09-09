package Calificaciones7E;

import java.util.Scanner;

public class EntradaCurso {
    private Scanner sc = new Scanner(System.in);

    // Pide al usuario el nombre del curso, validando que no esté vacío
    public String pedirNombreCurso() {
        String nombre;
        do {
            System.out.print("Ingrese el nombre del curso: ");
            nombre = sc.nextLine().trim();
            if (nombre.isEmpty()) {
                System.out.println("El nombre del curso no puede estar vacío.");
            }
        } while (nombre.isEmpty()); // repite hasta que se ingrese un nombre válido
        return nombre;
    }

    // Pide un número entero positivo (por ejemplo: número de estudiantes o evaluaciones)
    public int pedirEnteroPositivo(String mensaje) {
        int valor = 0;
        do {
            System.out.print(mensaje); // muestra el mensaje recibido como parámetro
            if (sc.hasNextInt()) { // verifica que se ingrese un número entero
                valor = sc.nextInt();
                if (valor <= 0) {
                    System.out.println("Debe ingresar un número positivo.");
                }
            } else {
                System.out.println("Debe ingresar un número entero.");
                sc.next();
            }
        } while (valor <= 0); // repite hasta que sea un número entero positivo
        sc.nextLine(); // limpiar buffer
        return valor;
    }
    // Pide los nombres de los estudiantes y los guarda en un arreglo
    public String[] pedirEstudiantes(int cantidad) {
        String[] estudiantes = new String[cantidad];
        for (int i = 0; i < cantidad; i++) {
            String nombre;
            do {
                System.out.print("Nombre del estudiante " + (i + 1) + ": ");
                nombre = sc.nextLine().trim(); // lee el nombre y elimina espacios con trim
                if (nombre.isEmpty()) {
                    System.out.println("El nombre no puede estar vacío.");
                }
            } while (nombre.isEmpty());
            estudiantes[i] = nombre; // guarda el nombre en el arreglo
        }
        return estudiantes;
    }

    // Pide las notas de cada estudiante en cada evaluación y las guarda en una matriz
    public double[][] pedirNotas(String[] estudiantes, int evaluaciones) {
        double[][] notas = new double[estudiantes.length][evaluaciones];
        // Recorre cada estudiante
        for (int i = 0; i < estudiantes.length; i++) {
            // Recorre cada evaluación del estudiante actual
            for (int j = 0; j < evaluaciones; j++) {
                double nota = -1; //se usa como valor inicial de control antes de que el usuario ingrese la nota real.
                do {
                    System.out.print("  Nota de " + estudiantes[i] + " en evaluación " + (j + 1) + ": ");
                    if (sc.hasNextDouble()) { // valida que la entrada sea numérica
                        nota = sc.nextDouble();
                        if (nota < 0 || nota > 100) { // repite hasta que la nota esté en el rango
                            System.out.println("La nota debe estar entre 0 y 100.");
                        }
                    } else {
                        System.out.println("Debe ingresar un número válido.");
                        sc.next();
                    }
                } while (nota < 0 || nota > 100);
                notas[i][j] = nota; // guarda la nota en la matriz
            }
            sc.nextLine(); // limpiar buffer
        }
        return notas;
    }
}
