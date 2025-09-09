package AgendaDeContacto;
import  java.util.Scanner;

public class Main {
    private Contacto[] agenda;
    private int contador;

    //constructor
    public Main(int tamaño) {
        agenda = new Contacto[tamaño];
        contador = 0;
    }

    // Par añadir contacto
    public void agregarContacto(String nombre, String telefono, String correo) {
        if (contador < agenda.length) {
            agenda[contador] = new Contacto(nombre, telefono, correo);
            contador++;
            System.out.println("Contacto añadido correctamente.");
        } else {
            System.out.println("La agenda está llena.");
        }
    }

    // Para buscar contacto por nombre
    public void buscarPorNombre(String nombre) {
        boolean encontrado = false;
        for (int i = 0; i < contador; i++) {
            if (agenda[i].getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Contacto encontrado: " + agenda[i]);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró un contacto con ese nombre.");
        }
    }

    // Para mostrar todos los contactos
    public void mostrarContactos() {
        if (contador == 0) {
            System.out.println("La agenda está vacía.");
        } else {
            System.out.println("Lista de contactos:");
            for (int i = 0; i < contador; i++) {
                System.out.println((i + 1) + ". " + agenda[i]);
            }
        }
    }

    // Para buscar contactos por dominio del correo
    public void buscarPorDominio(String dominio) {
        boolean encontrado = false;
        for (int i = 0; i < contador; i++) {
            if (agenda[i].getCorreo().endsWith(dominio)) {
                System.out.println(" Contacto con dominio " + dominio + ": " + agenda[i]);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println(" No se encontraron contactos con el dominio " + dominio);
        }
    }

    // El método
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main agenda = new Main(50); // capacidad máxima de 50 contactos
        int opcion;

        do {
            System.out.println("\n---  Agenda de Contactos ---");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar por nombre");
            System.out.println("3. Mostrar todos los contactos");
            System.out.println("4. Buscar por dominio de correo");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese teléfono: ");
                    String telefono = sc.nextLine();
                    System.out.print("Ingrese correo: ");
                    String correo = sc.nextLine();
                    agenda.agregarContacto(nombre, telefono, correo);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre a buscar: ");
                    String buscarNombre = sc.nextLine();
                    agenda.buscarPorNombre(buscarNombre);
                    break;
                case 3:
                    agenda.mostrarContactos();
                    break;
                case 4:
                    System.out.print("Ingrese el dominio (ejemplo: @gmail.com): ");
                    String dominio = sc.nextLine();
                    agenda.buscarPorDominio(dominio);
                    break;
                case 5:
                    System.out.println("Saliendo de la agenda...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}
