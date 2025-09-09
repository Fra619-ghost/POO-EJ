package GestorDeLibros;
import java.util.Scanner;

public class Main {
    private static Libro[] libros = new Libro[10];//Este es un arreglo fijo
    private static int contador = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            //decide hacerlo con un menu para mayor eficiencia
            System.out.println("\n📚 Menú:");
            System.out.println("1. Agregar libro");
            System.out.println("2. Buscar por autor");
            System.out.println("3. Buscar por título");
            System.out.println("4. Mostrar libros después de 2010");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // clean el buffer

            switch (opcion) {
                case 1:
                    agregarLibroDesdeInput(scanner);
                    break;
                case 2:
                    System.out.print("Ingresa el autor: ");
                    String autor = scanner.nextLine();
                    buscarPorAutor(autor);
                    break;
                case 3:
                    System.out.print("Ingresa palabra clave del título: ");
                    String palabra = scanner.nextLine();
                    buscarPorTitulo(palabra);
                    break;
                case 4:
                    mostrarLibrosRecientes();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    public static void agregarLibroDesdeInput(Scanner scanner) {
        //El contador para un limite de libros a agregar
        if (contador >= libros.length) {
            System.out.println("No se pueden agregar más libros.");
            return;
        }

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("Año: ");
        int anio = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        libros[contador++] = new Libro(titulo, autor, anio);
        System.out.println(" Libro agregado.");
    }

    public static void buscarPorAutor(String autor) {
        boolean encontrado = false;
        for (int i = 0; i < contador; i++) {
            if (libros[i].getAutor().equalsIgnoreCase(autor)) {
                System.out.println(libros[i]);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron libros de ese autor.");
        }
    }

    public static void buscarPorTitulo(String palabraClave) {
        boolean encontrado = false;
        for (int i = 0; i < contador; i++) {
            if (libros[i].getTitulo().toLowerCase().contains(palabraClave.toLowerCase())) {
                System.out.println(libros[i]);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron libros con esa palabra en el título.");
        }
    }

    public static void mostrarLibrosRecientes() {
        boolean encontrado = false;
        for (int i = 0; i < contador; i++) {
            if (libros[i].getAnio() > 2010) {
                System.out.println(libros[i]);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay libros publicados después de 2010.");
        }
    }

}
