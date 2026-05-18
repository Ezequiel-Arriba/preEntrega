
/**
 * Excepción propia: se lanza cuando se busca un producto que no existe.
 *
 * Extiende RuntimeException → no obliga a declarar throws en cada método.
 *
 *
 */
public class ProductoNoEncontrado extends RuntimeException {

    public ProductoNoEncontrado(int id) {
        super("Producto con este ID no encontrado: " + id);
    }
}

