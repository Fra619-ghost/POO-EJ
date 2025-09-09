package models;
import java.util.Scanner;
public class Ciudad {

    private int[][] temperaturas;
    public boolean ingresadas; //para controlar si ya se ingresaron temperaturas

    //constructor para inicializar e asignar valores
    public Ciudad() {
        temperaturas = new int[7][4]; //arreglo bidimensional de 7 días x 4 semanas
        ingresadas = false; //se inicializa en falso, porque aún no hay datos
    }

    //método para ingresar temperaturas, por 4 semanas
    public void ingresarTemperaturas(Scanner sc) {
        for (int semana = 0; semana < 4; semana++) {
            System.out.println("Semana " + (semana + 1));
            for (int dia = 0; dia < 7; dia++) {
                //se solicita la temperatura de cada día
                System.out.print("Ingrese la temperatura del día " + (dia + 1) + ": ");
                temperaturas[dia][semana] = sc.nextInt(); //se guarda en el arreglo
            }
        }
        //para luego verficar si hay temperaturas agregadas
        ingresadas = true;
    }

    //método para calcular el promedio semanal de la temperatura por semana
    public void PromedioSemanal() {
        //si aun no se han ingresado temperaturas, manda al menu de nuevo
        if (!ingresadas) {
            System.out.println("Aún no se han ingresado las temperaturas.");
            return;
        }

        //en caso que si hay temperaturas ingresadas
        for (int semana = 0; semana < 4; semana++) {
            int suma = 0;
            for (int dia = 0; dia < 7; dia++) {
                //se realiza la suma de todas las temperaturas de la semana
                suma += temperaturas[dia][semana];
            }
            //se divide la suma, entre los 7 dias
            double promedio = suma / 7.0;
            System.out.println("Promedio Semana " + (semana + 1) + ": " + promedio + "°C.");
        }
    }

    //metodo para identificar la temperatura maxima del mes
    public void TemperaturaMaximaMes() {
        //si aun no se han ingresado temperaturas, manda al menu de nuevo
        if (!ingresadas) {
            System.out.println("Aún no se han ingresado las temperaturas.");
            return;
        }

        //se inicializa con el primer valor de la matriz
        int max = temperaturas[0][0];
        for (int semana = 0; semana < 4; semana++) {
            for (int dia = 0; dia < 7; dia++) {
                if (temperaturas[dia][semana] > max) {
                    //se guarda la temperatura máxima, en la variable max
                    max = temperaturas[dia][semana];
                }
            }
        }
        System.out.println("La temperatura máxima del mes es: " + max + "°C.");
    }

    //método para identificar el día más frio de las 4 semanas
    public void DiaMasFrio() {
        //si aun no se han ingresado temperaturas, manda al menu de nuevo
        if (!ingresadas) {
            System.out.println("Aún no se han ingresado las temperaturas.");
            return;
        }

        //se inicializa con el primer valor
        int min = temperaturas[0][0];
        int diaMasFrio = 0;
        int semanaMasFria = 0;

        for (int semana = 0; semana < 4; semana++) {
            for (int dia = 0; dia < 7; dia++) {
                if (temperaturas[dia][semana] < min) {
                    //se actualiza la temperatura mínima
                    min = temperaturas[dia][semana];
                    diaMasFrio = dia; //posición del día
                    semanaMasFria = semana; //posición de la semana
                }
            }
        }
        //se muestra el resultado con la posición + 1, para que no inicie en 0
        System.out.println("El día más frío fue el día " + (diaMasFrio + 1) + " de la semana " +
                (semanaMasFria + 1) + " con " + min + "°C.");
    }
}
