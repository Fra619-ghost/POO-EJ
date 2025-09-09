package Modelos;

//clase con el atributo texto
public class AnalizadorTexto {
    private String texto;

    //constructor vacio
    public AnalizadorTexto() {
    }

    //constructor con atributo
    public AnalizadorTexto(String texto) {
        this.texto = texto;
    }

    //get y set
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    // metodo para contar palabras con Empty y split
    public int contarPalabras() {
        if (texto == null || texto.isEmpty()) {
            return 0;
        }
        String[] palabras = texto.split("\\s+"); // separa por espacios
        return palabras.length;
    }
    // metodo para conrar cuántas veces aparece una palabra específica, con el metodo equalsIgnoreCase
    public int contarPalabraEspecifica(String palabra) {
        if (texto == null || texto.isEmpty()) {
            return 0;
        }
        String[] palabras = texto.split("\\s+");
        int contador = 0;
        for (String p : palabras) {
            if (p.equalsIgnoreCase(palabra)) {
                contador++;
            }
        }
        return contador;
    }
    // metodo para reemplazar la palabra, con replaceAll
    public void reemplazarPalabra(String original, String nueva) {
        if (texto != null) {
            texto = texto.replaceAll("(?i)\\b" + original + "\\b", nueva); // reemplazo ignorando mayúsculas/minúsculas
        }
    }

    @Override
    public String toString() {
        return texto;
    }
}
