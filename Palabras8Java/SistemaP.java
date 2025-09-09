package Palabras8Java;



public class SistemaP {
    public static void main(String[] args) {
        EntradaUsuario entrada = new EntradaUsuario();

        int cantidad = entrada.pedirCantidad();
        String[] palabras = entrada.pedirPalabras(cantidad);

        Palabras analisis = new Palabras(palabras);
        analisis.mostrarResultados();
    }
}
