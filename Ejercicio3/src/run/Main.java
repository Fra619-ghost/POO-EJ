package run;
import models.Producto;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Producto producto = new Producto(100); //se crea el objeto producto con capacidad de 100
        Scanner sc = new Scanner(System.in);

        boolean salir = false; //control del menú

        while (!salir) {
            System.out.println("\n------- MENU ------");
            System.out.println("1. Añadir Producto");
            System.out.println("2. Buscar Producto");
            System.out.println("3. Mostrar Productos Escasos (< 5)");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); //limpia el buffer

            switch (opcion) {
                case 1:
                    //agregar producto
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Código: ");
                    String codigo = sc.nextLine();
                    System.out.print("Cantidad: ");
                    int cant = sc.nextInt();
                    sc.nextLine();
                    producto.addProducto(nombre, codigo, cant);
                    System.out.println("Producto agregado exitosamente.");
                    break;

                case 2:
                    //buscar producto
                    if(producto.getContProductos() ==0){
                        System.out.println("Aún no hay productos registrados");
                        break;
                    } else {
                        System.out.print("Ingrese el código a buscar: ");
                        String buscar = sc.nextLine();
                        System.out.println(producto.buscarProducto(buscar));
                        break;
                    }

                case 3:
                    //mostrar productos escasos
                    producto.mostrarEscasos();
                    break;

                case 4:
                    //salir
                    salir = true;
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        sc.close(); //cerrar scanner
    }
}
