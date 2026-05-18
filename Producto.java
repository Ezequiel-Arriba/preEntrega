
/**
 * Modelo que representa un producto de la tienda.
 * El id se asigna automáticamente 
 *
 * En Spring Boot con JPA este id lo va a manejar la base de datos.
 * Por eso más adelante vamos a agregar un constructor vacío y @Entity.
 */
public class Producto {

    // Contador compartido por todos los objetos — genera ids únicos
    private static int contadorId = 1;
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    /**
     * Constructor principal. El id se asigna automáticamente.
     */
    public Producto(String nombre, double precio, int stock) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters 
    public int getId()        { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock()     { return stock; }

    // Setters 
    public void setPrecio(double precio) { this.precio = precio; }
    public void setStock(int stock)      { this.stock = stock; }


    @Override
    public String toString() {
        return "[ID: " + id + "] " + nombre +
               " | Precio: $" + precio +
               " | Stock: " + stock;
    }
}
