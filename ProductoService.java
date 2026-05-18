
import java.util.ArrayList;

/**
 * Servicio que contiene la lógica de negocio.
 * Gestiona la lista de productos en memoria.
 *
 * 
 */
public class ProductoService {

    // Lista que simula la base de datos — se pierde al cerrar el programa
    private ArrayList<Producto> productos = new ArrayList<>();

    /**
     * Agrega un nuevo producto. La validación de datos se hace en Main.
     */
    public void agregar(String nombre, double precio, int stock) {
        Producto nuevo = new Producto(nombre, precio, stock);
        productos.add(nuevo);
        System.out.println("Producto agregado: " + nuevo);
    }

    /**
     * Lista todos los productos. Si no hay ninguno, avisa.
     */
    public void listar() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos cargados.");
            return;
        }
        System.out.println("\n--- Listado de productos ---");
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    /**
     * Busca un producto por ID.
     * Si no existe, lanza ProductoNoEncontrado
     */
    public Producto buscarPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        
        throw new ProductoNoEncontrado(id);
    }

    /**
     * Elimina un producto por ID.
        * Si no existe, lanza ProductoNoEncontrado
     */
    public void eliminar(int id) {
        Producto p = buscarPorId(id);
        productos.remove(p);
        System.out.println("Producto eliminado: " + p.getNombre());
    }


    
    public void modificar(int id, String nuevoNombre, double nuevoPrecio, int nuevoStock) {
        Producto p = buscarPorId(id);

        try {
            p.getClass().getMethod("setNombre", String.class).invoke(p, nuevoNombre);
        } catch (NoSuchMethodException e) {
            try {
                java.lang.reflect.Field nombreField = p.getClass().getDeclaredField("nombre");
                nombreField.setAccessible(true);
                nombreField.set(p, nuevoNombre);
            } catch (Exception ex) {
                throw new RuntimeException("No se pudo modificar el nombre del producto", ex);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al modificar el nombre del producto", e);
        }

        p.setPrecio(nuevoPrecio);
        p.setStock(nuevoStock);
        System.out.println("Producto modificado: " + p);
    }
}
