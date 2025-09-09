package Calificaciones7E;

public class Calificaciones {
    private String nombre;            // Nombre del curso
    private double[][] notas;         // Matriz de notas [estudiantes][evaluaciones]
    private String[] estudiantes;     // Arreglo con los nombres de los estudiantes

    public Calificaciones(String nombre, String[] estudiantes, double[][] notas) {
        this.nombre = nombre;
        this.estudiantes = estudiantes;
        this.notas = notas;
    }

    // Promedio por estudiante
    public double promedioEstudiante(int indiceEstu) {
        double suma = 0; //acumulador de notas
        // Recorre todas las evaluaciones del estudiante indicado
        for (int j = 0; j < notas[indiceEstu].length; j++) {
            suma += notas[indiceEstu][j]; //suma cada nota
        }
        // Retorna el promedio dividiendo la suma entre el número de evaluaciones
        return suma / notas[indiceEstu].length;
    }

    // Promedio por evaluación
    public double promedioEvaluacion(int indiceEvaluacion) {
        double suma = 0;
        // Recorre todos los estudiantes (filas de la matriz)
        for (int i = 0; i < notas.length; i++) {
            suma += notas[i][indiceEvaluacion];
        }
        // Retorna el promedio dividiendo la suma entre el número de estudiantes
        return suma / notas.length;
    }

    // Mejor estudiante
    public String mejorEstudiante() {
        double mejor = 0; // guarda el promedio más alto encontrado
        int indiceMejor = 0; // índice del mejor estudiante
        // Recorre todos los estudiantes
        for (int i = 0; i < notas.length; i++) {
            double promedio = promedioEstudiante(i);
            // Si este promedio es mayor al mejor encontrado, se actualiza
            if (promedio > mejor) {
                mejor = promedio;
                indiceMejor = i;
            }
        }
        // Retorna el nombre del mejor estudiante con su promedio formateado a 2 decimales
        return estudiantes[indiceMejor] + " con promedio " + String.format("%.2f", mejor);
    }

    // Mostrar resultados
    public void mostrarResultados() {
        System.out.println("\nResultados del curso: " + nombre);

        System.out.println("Promedio por estudiante:");
        for (int i = 0; i < estudiantes.length; i++) {
            // Muestra el nombre del estudiante y su promedio formateado con 2 decimales
            System.out.println(estudiantes[i] + ": " + String.format("%.2f", promedioEstudiante(i)));
        }

        System.out.println("\nPromedio por evaluación:");
        for (int j = 0; j < notas[0].length; j++) {
            // Muestra el número de la evaluación (j+1) y su promedio formateado con 2 decimales
            System.out.println("Evaluación " + (j + 1) + ": " + String.format("%.2f", promedioEvaluacion(j)));
        }

        System.out.println("\nMejor estudiante: " + mejorEstudiante());
    }
}
