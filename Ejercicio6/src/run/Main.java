package run;
import models.Ciudad;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ciudad ciudad = new Ciudad(); //se crea un objeto de la clase Ciudad
        Scanner sc = new Scanner(System.in); //scanner para leer datos del usuario

        boolean salir = false; //control del menú
        while (!salir) { //ciclo para mostrar el menú hasta que se elija salir
            System.out.println("\n------- MENU ------");
            System.out.println("1. Ingresar Temperaturas");
            System.out.println("2. Promedio Semanal");
            System.out.println("3. Temperatura Máxima del Mes");
            System.out.println("4. Día Más Frío (Día y Semana)");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            int opcion = sc.nextInt(); //leer la opción ingresada

            switch (opcion) {
                case 1:
                    //leer las temperaturas
                    ciudad.ingresarTemperaturas(sc);
                    break;
                case 2:
                    //mostrar promedio semanal
                    ciudad.PromedioSemanal();
                    break;
                case 3:
                    //mostrar temperatura máxima
                    ciudad.TemperaturaMaximaMes();
                    break;
                case 4:
                    //mostrar el día más frío
                    ciudad.DiaMasFrio();
                    break;
                case 5:
                    //salir del ciclo
                    salir = true;
                    break;
                default:
                    //en caso que se ingrese un número fuera de rango
                    System.out.println("Opción no válida.");
            }
        }
        sc.close(); //cerrar al final el Scanner
    }
}
