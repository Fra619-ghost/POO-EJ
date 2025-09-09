package Run;
import Modelos.AnalizadorTexto;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingresa un texto: ");
        String texto = entrada.nextLine();

        AnalizadorTexto analizador = new AnalizadorTexto(texto);

        // Contar palabras
        System.out.println("Cantidad de palabras: " + analizador.contarPalabras());

        // Contar palabra específica
        System.out.print("Ingrese una palabra para buscar: ");
        String palabra = entrada.nextLine();
        System.out.println("La palabra '" + palabra + "' aparece " + analizador.contarPalabraEspecifica(palabra) + " veces.");

        // Reemplazar palabra
        System.out.print("Ingrese la palabra a reemplazar: ");
        String original = entrada.nextLine();
        System.out.print("Ingrese la nueva palabra: ");
        String nueva = entrada.nextLine();
        analizador.reemplazarPalabra(original, nueva);

        System.out.println("Texto modificado: " + analizador);
    }
}
