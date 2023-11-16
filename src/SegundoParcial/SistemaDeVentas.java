import java.sql.*;
import java.util.ArrayList;

class DBHelper {
    private static final String URL = "jdbc:mysql://localhost:33061/ventas_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Método para ejecutar una consulta sin devolver resultados
    public static void ejecutarConsulta(String consulta) {
        try {
            // Establecer la conexión con la base de datos
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Crear la declaración
            try (PreparedStatement statement = connection.prepareStatement(consulta)) {
                // Ejecutar la consulta
                statement.executeUpdate();
            }

            // Cerrar la conexión
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para ejecutar una consulta y devolver un conjunto de resultados
    public static ResultSet ejecutarConsultaConResultado(String consulta) {
        try {
            // Establecer la conexión con la base de datos
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Crear la declaración
            PreparedStatement statement = connection.prepareStatement(consulta);

            // Ejecutar la consulta y devolver el conjunto de resultados
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
class Producto {
    private int producto_id;
    private String nombre;
    private double precio_por_unidad;
    private int stock;

    public Producto(int producto_id, String nombre, double precio_por_unidad, int stock) {
        this.producto_id = producto_id;
        this.nombre = nombre;
        this.precio_por_unidad = precio_por_unidad;
        this.stock = stock;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio_por_unidad() {
        return precio_por_unidad;
    }

    public int getStock() {
        return stock;
    }

    public static Producto obtenerProducto(int productoID) {
        // Crear la consulta
        String consulta = "SELECT * FROM productos WHERE producto_id = " + productoID;
        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);
        try {
            if (resultado == null || !resultado.next()) {
                return null;
            } else {
                // Crear el producto
                Producto producto = new Producto(
                        resultado.getInt("producto_id"),
                        resultado.getString("nombre"),
                        resultado.getDouble("precio_por_unidad"),
                        resultado.getInt("stock")
                );
                // Retornar el producto
                return producto;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Producto obtenerProductoMasVendido() {
        // Crear la consulta
        String consulta = "SELECT * FROM productos ORDER BY stock ASC LIMIT 1";
        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);
        try {
            if (resultado == null || !resultado.next()) {
                return null;
            } else {
                // Crear el producto
                Producto producto = new Producto(
                        resultado.getInt("producto_id"),
                        resultado.getString("nombre"),
                        resultado.getDouble("precio_por_unidad"),
                        resultado.getInt("stock")
                );
                // Retornar el producto
                return producto;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String toString() {
        return "Id producto: " + producto_id + "\n" +
                "Nombre: " + nombre + "\n" +
                "Precio por unidad: " + precio_por_unidad + "\n" +
                "Stock: " + stock + "\n";
    }

}
class Vendedor {
    private int vendedor_id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fecha_nacimiento;
    private Date fecha_contratacion;
    public Vendedor(int vendedor_id, String nombre, String apellido, String dni, Date fecha_nacimiento, Date fecha_contratacion) {
        this.vendedor_id = vendedor_id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_contratacion = fecha_contratacion;
    }
    public Vendedor(String consulta) {
        try {
            // Ejecutar la consulta y obtener el conjunto de resultados
            ResultSet resultSet = DBHelper.ejecutarConsultaConResultado(consulta);

            // Recorrer el conjunto de resultados
            while (resultSet.next()) {
                // Obtener los datos de la fila actual
                this.vendedor_id = resultSet.getInt("vendedor_id");
                this.nombre = resultSet.getString("nombre");
                this.apellido = resultSet.getString("apellido");
                this.dni = resultSet.getString("dni");
                this.fecha_nacimiento = resultSet.getDate("fecha_nacimiento");
                this.fecha_contratacion = resultSet.getDate("fecha_contratacion");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getVendedor_id() {
        return vendedor_id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public Date getFecha_contratacion() {
        return fecha_contratacion;
    }
    public String toString() {
        return "Id vendedor: " + vendedor_id + "\n" +
                "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "DNI: " + dni + "\n" +
                "Fecha de nacimiento: " + fecha_nacimiento + "\n" +
                "Fecha de contratación: " + fecha_contratacion + "\n";
    }
}
class Venta {
    private int venta_id;
    private int vendedor_id;
    private int producto_id;
    private int cantidad_vendida;
    private Date fecha_venta;

    public Venta(int venta_id, int vendedor_id, int producto_id, int cantidad_vendida, Date fecha_venta) {
        this.venta_id = venta_id;
        this.vendedor_id = vendedor_id;
        this.producto_id = producto_id;
        this.cantidad_vendida = cantidad_vendida;
        this.fecha_venta = fecha_venta;
    }

    public int getVenta_id() {
        return venta_id;
    }

    public int getVendedor_id() {
        return vendedor_id;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public int getCantidad_vendida() {
        return cantidad_vendida;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

}

class Comerciales {
    public static Vendedor obtenerVendedorPorID(int vendedorID) {
        // Crear la consulta
        String consulta = "SELECT * FROM vendedores WHERE vendedor_id = " + vendedorID;
        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);
        // Crear el vendedor
        Vendedor vendedor = new Vendedor(consulta);
        try {
            if (resultado == null && !resultado.next()) {
                return null;
            } else {
                // Retornar el vendedor
                return vendedor;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList <Vendedor> listadoDeVendedores() {
        // Crear la consulta
        String consulta = "SELECT * FROM vendedores";
        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);
        ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
        try {
            if (resultado == null && !resultado.next()) {
                return null;
            } else {
                // Crear el vendedor
                while (resultado.next()) {
                    Vendedor vendedor = new Vendedor(
                            resultado.getInt("vendedor_id"),
                            resultado.getString("nombre"),
                            resultado.getString("apellido"),
                            resultado.getString("dni"),
                            resultado.getDate("fecha_nacimiento"),
                            resultado.getDate("fecha_contratacion")
                    );
                    vendedores.add(vendedor);
                }
                // Retornar el vendedor
                return vendedores;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

public class SistemaDeVentas {
    public static void main(String[] args) {
        System.out.println("punto 3");
        // Punto 3.Creación de un Constructor Adicional en la clase Vendedor
        Vendedor vendedorBuscado = new Vendedor("SELECT * FROM `vendedores` WHERE `vendedor_id` = 3");
        System.out.println(vendedorBuscado);

        System.out.println("punto 4");
        // Punto 4. Obtener los datos de un Vendedor
        Vendedor vendedor = Comerciales.obtenerVendedorPorID(1);
        System.out.println(vendedor);

        System.out.println("punto 5");
        // Punto 5.Generación de Informe de Productos en Stock
        generarInforme();

        System.out.println("punto 6");
        // Punto 6. Obtener Producto por ID
        Producto producto = Producto.obtenerProducto(1);
        System.out.println(producto);

        System.out.println("punto 7");
        // Punto 7. Obtener Producto más Vendido
        Producto productoMasVendido = Producto.obtenerProductoMasVendido();
        System.out.println(productoMasVendido);


        System.out.println("punto 8");
        // Punto 8. Obtener el Listado de Vendedores
        ArrayList<Vendedor> vendedores = Comerciales.listadoDeVendedores();
        for (Vendedor vendedor1 : vendedores) {
            System.out.println(vendedor1);
        }



    }
    public static void generarInforme() {
        // Crear la consulta
        String consulta = "SELECT * FROM productos";
        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);
        try {
            if (resultado == null && !resultado.next()) {
                System.out.println("No hay productos en stock");
            } else {
                // Imprimir el encabezado
                System.out.printf("%-10s %-15s %-5s %-20s %-12s %-10s\n", "ID", "Nombre", "Stock", "Precio por unidad", "Valor total", "Valor total de todos los productos");
                // Recorrer el conjunto de resultados
                while (resultado.next()) {
                    // Obtener los datos de la fila actual
                    int producto_id = resultado.getInt("producto_id");
                    String nombre = resultado.getString("nombre");
                    int stock = resultado.getInt("stock");
                    double precio_por_unidad = resultado.getDouble("precio_por_unidad");
                    double valor_total = stock * precio_por_unidad;
                    // Imprimir los datos de la fila actual
                    System.out.printf("%-10s %-15s %-5s %-20s %-12s %-10s\n", producto_id, nombre, stock, precio_por_unidad, valor_total, valor_total);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}