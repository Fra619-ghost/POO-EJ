package models;

public class Producto {private String[] nombre;
    //atributos
    private String[] codigo;
    private int[] cantidad;
    private int contProductos;

    //método getter
    public int getContProductos() {
        return contProductos;
    }

    //constructor de la clase, se le pasa el parametro "capacidad" para definir el tamaño maximo
    public Producto(int capacidad) {
        nombre = new String[capacidad];
        codigo = new String[capacidad];
        cantidad = new int[capacidad];
        contProductos = 0;
    }

    //metodo para agregar un nuevo producto
    public void addProducto(String nombre, String codigo, int cantidad) {
        //compara el contador con la capacidad máxima (el largo del arreglo de nombres).
        if (contProductos < this.nombre.length) {
            this.nombre[contProductos] = nombre;
            this.codigo[contProductos] = codigo;
            this.cantidad[contProductos] = cantidad;
            contProductos++;
        } else {
            System.out.println("Inventario lleno, no se pueden agregar más productos.");
        }
    }

    //método para buscar producto por su código
    public String buscarProducto(String codigo) {
        for (int i = 0; i < contProductos; i++) {
            if (this.codigo[i].equals(codigo)) { //equals para comparar Strings
                return "Producto encontrado:" +
                        "\nNombre: " + this.nombre[i] +
                        "\nCódigo: " + this.codigo[i] +
                        "\nCantidad: " + this.cantidad[i];
            }
        }
        return "No existe el producto con el código " + codigo;
    }

    //método para mostrar productos con stock menor a 5
    public void mostrarEscasos() {
        if (contProductos == 0) {
            System.out.println("Aún no hay productos registrados.");
            return;
        }

        //se usa una bandera para ver si se encontro algun producto escaso
        boolean escasos = false;
        for (int i = 0; i < contProductos; i++) {
            if (this.cantidad[i] < 5) {
                System.out.println("Producto con stock menor a 5:");
                System.out.println("Nombre: " + nombre[i] + " Código: " + codigo[i] +
                        " Cantidad: " + cantidad[i]);
                //se cambia la bandera a true, pq se encontro 1
                escasos = true;
            }
        }
        if (!escasos) {
            System.out.println("No hay productos con stock menor a 5.");
        }
    }
}


