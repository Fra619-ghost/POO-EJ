/*Sistema de Calificaciones
        Objetivo: Clase Curso que tiene un nombre y una matriz de notas (estudiantes x evaluaciones).
        •    Método para promedio por estudiante.
        •    Método para promedio por evaluación.
        •    Estudiante con mejor rendimiento.*/

package Ejercicio7Scalificaciones;

import java.util.Scanner;

// Clase que representa un curso con sus estudiantes y calificaciones
class Calificaciones {
    private String nombre;            // Nombre del curso
    private double[][] notas;         // Matriz de notas [estudiantes][evaluaciones]
    private String[] estudiantes;     // Arreglo con los nombres de los estudiantes

    // Constructor que recibe nombre del curso, arreglo de estudiantes y matriz de notas
    Calificaciones(String nombre, String[] estudiantes, double[][] notas) {
        this.nombre = nombre;
        this.estudiantes = estudiantes;
        this.notas = notas;
    }

    // Promedio por estudiante usando for doble
    public double promedioEstudiante(int indiceEstu) {
        double suma = 0;
        for (int i = indiceEstu; i <= indiceEstu; i++) {        // solo la fila del estudiante
            for (int j = 0; j < notas[i].length; j++) {         // recorre todas las evaluaciones
                suma += notas[i][j];
            }
        }
        return suma / notas[indiceEstu].length;                  // retorna el promedio
    }

    // Promedio por evaluación usando for doble
    public double promedioEvaluacion(int indiceEvaluacion) {
        double suma = 0;
        for (int i = 0; i < notas.length; i++) {               // recorre todas las filas (estudiantes)
            for (int j = indiceEvaluacion; j <= indiceEvaluacion; j++) { // solo la columna deseada
                suma += notas[i][j];
            }
        }
        return suma / notas.length;                              // retorna el promedio
    }

    // Mejor estudiante del curso
    public String mejorEstudiante() {
        double mejor = 0;
        int indiceMejor = 0;
        for (int i = 0; i < notas.length; i++) {               // recorre cada estudiante
            double suma = 0;
            for (int j = 0; j < notas[i].length; j++) {       // suma todas sus evaluaciones
                suma += notas[i][j];
            }
            double promedio = suma / notas[i].length;
            if (promedio > mejor) {
                mejor = promedio;
                indiceMejor = i;
            }
        }
        return estudiantes[indiceMejor] + " con promedio " + String.format("%.2f", mejor);
    }

    // Mostrar resultados del curso
    public void mostrarResultados() {
        System.out.println("\nResultados del curso: " + nombre);

        System.out.println("Promedio por estudiante:");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println(estudiantes[i] + ": " + String.format("%.2f", promedioEstudiante(i)));
        }

        System.out.println("\nPromedio por evaluación:");
        for (int j = 0; j < notas[0].length; j++) {
            System.out.println("Evaluación " + (j + 1) + ": " + String.format("%.2f", promedioEvaluacion(j)));
        }

        System.out.println("\nMejor estudiante: " + mejorEstudiante());
    }
}

// Clase principal para interacción con el usuario
public class SistemaC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ingreso del nombre del curso con validación mínima
        String nombre;
        do {
            System.out.print("Ingrese el nombre del curso: ");
            nombre = sc.nextLine().trim();
            if (nombre.isEmpty()) {
                System.out.println("El nombre del curso no puede estar vacío.");
            }
        } while (nombre.isEmpty());

        // Número de estudiantes con validación mínima
        int NEstudiantes = 0;
        do {
            System.out.print("Ingrese el número de estudiantes: ");
            if (sc.hasNextInt()) {
                NEstudiantes = sc.nextInt();
                if (NEstudiantes <= 0) {
                    System.out.println("Debe ingresar un número positivo.");
                }
            } else {
                System.out.println("Debe ingresar un número entero.");
                sc.next();
            }
        } while (NEstudiantes <= 0);

        // Número de evaluaciones con validación mínima
        int NCalificaciones = 0;
        do {
            System.out.print("Ingrese el número de evaluaciones: ");
            if (sc.hasNextInt()) {
                NCalificaciones = sc.nextInt();
                if (NCalificaciones <= 0) {
                    System.out.println("Debe ingresar un número positivo.");
                }
            } else {
                System.out.println("Debe ingresar un número entero.");
                sc.next();
            }
        } while (NCalificaciones <= 0);

        sc.nextLine(); // limpiar buffer antes de leer nombres

        String[] estudiantes = new String[NEstudiantes];
        double[][] notas = new double[NEstudiantes][NCalificaciones];

        // Ingreso de nombres y notas de estudiantes con validación
        for (int i = 0; i < NEstudiantes; i++) {
            String nombreEstudiante;
            do {
                System.out.print("\nNombre del estudiante " + (i + 1) + ": ");
                nombreEstudiante = sc.nextLine().trim();
                if (nombreEstudiante.isEmpty()) {
                    System.out.println("El nombre del estudiante no puede estar vacío.");
                }
            } while (nombreEstudiante.isEmpty());
            estudiantes[i] = nombreEstudiante;

            // Ingreso de notas con validación (0-100)
            for (int j = 0; j < NCalificaciones; j++) {
                double nota = -1;
                do {
                    System.out.print("  Nota de " + estudiantes[i] + " en evaluación " + (j + 1) + ": ");
                    if (sc.hasNextDouble()) {
                        nota = sc.nextDouble();
                        if (nota < 0 || nota > 100) {
                            System.out.println("La nota debe estar entre 0 y 100.");
                        }
                    } else {
                        System.out.println("Debe ingresar un número válido.");
                        sc.next();
                    }
                } while (nota < 0 || nota > 100);
                notas[i][j] = nota;
            }
            sc.nextLine(); // limpiar buffer después de cada estudiante
        }

        // Crear curso y mostrar resultados
        Calificaciones curso = new Calificaciones(nombre, estudiantes, notas);
        curso.mostrarResultados();
    }
}


