package Palabras8Java;


import java.util.HashSet;
import java.util.Set;

public class Palabras {
    private String[] palabras; // Arreglo que almacena todas las palabras

    public Palabras(String[] palabras) {
        this.palabras = palabras;
    }

    // Contar cuántas palabras hay
    public void contarPalabras() {
        System.out.println("Cantidad total de palabras: " + palabras.length);
    }

    // Mostrar palabras únicas (sin repetición)
    public void palabrasUnicas() {
        Set<String> unicas = new HashSet<>(); //HashSet es una lista que no permtve duplicados
        for (String palabra : palabras) {
            unicas.add(palabra);
        }
        System.out.println("Palabras únicas: " + unicas);
    }

    // Mostrar la palabra más corta
    public void palabrasMasCorta() {
        if (palabras.length == 0) {
            System.out.println("No hay palabras para analizar.");
            return;
        }

        String masCorta = palabras[0];
        for (String palabra : palabras) {
            if (palabra.length() < masCorta.length()) {
                masCorta = palabra;
            }
        }
        System.out.println("Palabra más corta: " + masCorta);
    }

    // Mostrar la palabra más larga
    public void palabrasMasLarga() {
        if (palabras.length == 0) {
            System.out.println("No hay palabras para analizar.");
            return;
        }

        String masLarga = palabras[0];
        for (String palabra : palabras) {
            if (palabra.length() > masLarga.length()) {
                masLarga = palabra;
            }
        }
        System.out.println("Palabra más larga: " + masLarga);
    }

    public void mostrarResultados() {
        contarPalabras();
        palabrasUnicas();
        palabrasMasCorta();
        palabrasMasLarga();
    }
}
