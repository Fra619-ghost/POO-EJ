package Calificaciones7E;

public class SistemaC {
    public static void main(String[] args) {
        EntradaCurso entrada = new EntradaCurso();

        String nombreCurso = entrada.pedirNombreCurso();
        int nEstudiantes = entrada.pedirEnteroPositivo("Ingrese el número de estudiantes: ");
        int nEvaluaciones = entrada.pedirEnteroPositivo("Ingrese el número de evaluaciones: ");

        // Se solicita al usuario el nombre de cada estudiante y se guarda en un arreglo de Strings
        String[] estudiantes = entrada.pedirEstudiantes(nEstudiantes);
        // Se solicita al usuario las notas de cada estudiante en cada evaluación
// y se guarda en una matriz de tipo double [estudiantes][evaluaciones]
        double[][] notas = entrada.pedirNotas(estudiantes, nEvaluaciones);

        Calificaciones curso = new Calificaciones(nombreCurso, estudiantes, notas);
        curso.mostrarResultados();
    }
}
