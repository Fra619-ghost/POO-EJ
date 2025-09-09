package Modelos;

//atributos del estudiante
public class Estudiante {
    private String nombre;
    private int edad;
    private double[] notas;

    //constructor vacio
    public Estudiante() {
    }

    //constructor con los atributos
    public Estudiante(String nombre, int edad, double[] notas) {
        this.nombre = nombre;
        this.edad = edad;
        this.notas = notas;
    }

    //get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    //metodo que calcule el promedio
    public double calcularPromedio(){
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.length; //se divide entre lenght que es la cantidad de notas
    }

    //metodo que vaya a mostrar los datos
    public void MostrarDatos(){
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Edad: " + this.edad);
        System.out.print("Notas: ");
        for (double nota : notas) {
            System.out.print(nota + " ");
        }
        System.out.println("\nPromedio: " + calcularPromedio());
    }


}
