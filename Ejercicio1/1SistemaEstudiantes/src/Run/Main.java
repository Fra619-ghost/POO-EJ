package Run;
import java.util.Scanner;
import Modelos.Estudiante;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // preguntar cuántos estudiantes se van a registrar
        System.out.print("Ingrese la cantidad de estudiantes: ");
        int cantidad = entrada.nextInt();
        entrada.nextLine(); // limpiar buffer

        // crea arreglo de estudiantes
        Estudiante[] estudiantes = new Estudiante[cantidad];

        // Registra cada estudiante
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- Estudiante " + (i + 1) + " ---");

            // Crear estudiante vacío
            Estudiante estudiante = new Estudiante();

            System.out.print("Nombre: ");
            String nombre = entrada.nextLine();
            estudiante.setNombre(nombre);

            System.out.print("Edad: ");
            int edad = entrada.nextInt();
            estudiante.setEdad(edad);

            System.out.print("Cantidad de notas: ");
            int cantNotas = entrada.nextInt();

            double[] notas = new double[cantNotas];
            for (int j = 0; j < cantNotas; j++) {
                System.out.print("Nota " + (j + 1) + ": ");
                notas[j] = entrada.nextDouble();
            }
            estudiante.setNotas(notas);

            entrada.nextLine();

            // Guardar en el arreglo
            estudiantes[i] = estudiante;
        }

        // Mostrar solo los estudiantes con promedio mayor a 8
        System.out.println("\nEstudiantes con promedio mayor a 8: ");
        for (Estudiante estu : estudiantes) {
            if (estu.calcularPromedio() > 8.0) {
                estu.MostrarDatos();
            }
        }
    }
}
