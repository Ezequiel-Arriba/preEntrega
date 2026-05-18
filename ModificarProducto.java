import java.util.List;
import java.util.Optional;

public class ModificarProducto {

    public static class Producto {
        private int id;
        private String nombre;
        private double precio;
        private int stock;

        public Producto(int id, String nombre, double precio, int stock) {
            this.id = id;
            this.nombre = nombre;
            this.precio = precio;
            this.stock = stock;
        }

        public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        @Override
        public String toString() {
            return "Producto{id=" + id + ", nombre='" + nombre + "', precio=" + precio + ", stock=" + stock + " }";
        }
    }

    public static boolean modificarProductoPorId(List<Producto> productos, int id, String nuevoNombre, double nuevoPrecio, int nuevoStock) {
        Optional<Producto> productoEncontrado = productos.stream()
                .filter(producto -> producto.getId() == id)
                .findFirst();

        if (productoEncontrado.isPresent()) {
            Producto producto = productoEncontrado.get();
            producto.setNombre(nuevoNombre);
            producto.setPrecio(nuevoPrecio);
            producto.setStock(nuevoStock);
            return true;
        }
        return false;
    }

}
