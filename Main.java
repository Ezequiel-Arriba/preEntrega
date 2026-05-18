
import java.util.Scanner;

/**
 * Inicio de la aplicación.
 * Funcionalidades: leer datos, validar con if, delegar al servicio.
 *
 * Las validaciones son simples (if) — sin clases utilitarias,
 * para mantener el código accesible.
 *
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductoService servicio = new ProductoService();
        int opcion = -1;

        System.out.println("=== Gestión de Stock ===");

        while (opcion != 0) {

            System.out.println("\nMenú: (ingresá el número)");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar por ID");
            System.out.println("4. Eliminar por ID");
            System.err.println("5. Modificar por ID");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            // Validamos que ingrese un número
            if (!sc.hasNextInt()) {
                System.out.println("Ingresá un número válido.");
                sc.next();
                continue;
            }

            opcion = sc.nextInt();
            sc.nextLine(); 

            if (opcion == 1) {

                System.out.print("Nombre: ");
                String nombre = sc.nextLine();

                if (nombre.isBlank()) {
                    System.out.println("El nombre no puede estar vacío.");
                    continue;
                }

                System.out.print("Precio: ");
                if (!sc.hasNextDouble()) {
                    System.out.println("El precio debe ser un número.");
                    sc.next();
                    continue;
                }
                double precio = sc.nextDouble();

                if (precio <= 0) {
                    System.out.println("El precio debe ser mayor a cero.");
                    sc.nextLine();
                    continue;
                }

                System.out.print("Stock: ");
                if (!sc.hasNextInt()) {
                    System.out.println("El stock debe ser un número entero.");
                    sc.next();
                    continue;
                }
                int stock = sc.nextInt();
                sc.nextLine();

                if (stock < 0) {
                    System.out.println("El stock no puede ser negativo.");
                    continue;
                }

                servicio.agregar(nombre, precio, stock);

            } else if (opcion == 2) {

                servicio.listar();

            } else if (opcion == 3) {

                System.out.print("ID a buscar: ");
                if (!sc.hasNextInt()) {
                    System.out.println("Ingresá un ID válido.");
                    sc.next();
                    continue;
                }
                int id = sc.nextInt();
                sc.nextLine();

                try {
                    Producto p = servicio.buscarPorId(id);
                    System.out.println("Encontrado: " + p);
                } catch (ProductoNoEncontrado e) {
                    System.out.println(e.getMessage());
                }

            } else if (opcion == 4) {

                System.out.print("ID a eliminar: ");
                if (!sc.hasNextInt()) {
                    System.out.println("Ingresá un ID válido.");
                    sc.next();
                    continue;
                }
                int id = sc.nextInt();
                sc.nextLine();

                try {
                    servicio.eliminar(id);
                } catch (ProductoNoEncontrado e) {
                    System.out.println(e.getMessage());
                }

            } else if (opcion == 5) {

                System.out.print("ID a modificar: ");
                if (!sc.hasNextInt()) {
                    System.out.println("Ingresá un ID válido.");
                    sc.next();
                    continue;
                }
                int id = sc.nextInt();
                sc.nextLine();

                try {
                    Producto p = servicio.buscarPorId(id);
                    System.out.println("Producto encontrado: " + p);

                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();

                    System.out.print("Nuevo precio: ");
                    if (!sc.hasNextDouble()) {
                        System.out.println("El precio debe ser un número.");
                        sc.next();
                        continue;
                    }
                    double nuevoPrecio = sc.nextDouble();
                    sc.nextLine();

                    if (nuevoPrecio <= 0) {
                        System.out.println("El precio debe ser mayor a cero.");
                        continue;
                    }

                    System.out.print("Nuevo stock: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("El stock debe ser un número entero.");
                        sc.next();
                        continue;
                    }
                    int nuevoStock = sc.nextInt();
                    sc.nextLine();

                    if (nuevoStock < 0) {
                        System.out.println("El stock no puede ser negativo.");
                        continue;
                    }

                    servicio.modificar(id, nuevoNombre, nuevoPrecio, nuevoStock);

                } catch (ProductoNoEncontrado e) {
                    System.out.println(e.getMessage());
                }

            } else if (opcion != 0) {
                System.out.println("Opción no válida. Elegí entre 0 y 4.");
            }
        }

        System.out.println("¡Hasta luego!");
        sc.close();
    }
}