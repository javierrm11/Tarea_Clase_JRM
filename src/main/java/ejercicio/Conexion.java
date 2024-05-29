package ejercicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3307/Empresa?allowPublicKeyRetrieval=true&useSSL=false";  // Ruta de la base de datos
    private static final String USUARIO = "root"; // Usuario de la base de datos
    private static final String CLAVE = "Jrr#108vivi"; // Contraseña

    private static Connection conexion = null;

    // Metodo de conectar a la base de datos
    public static Connection conectar() {
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE); // Metodo de Drivers y como parametros la url, usuario y la clave
            System.out.println("Conexión OK");
        } catch (SQLException e) {
            System.out.println("Error en la conexión");
            e.printStackTrace();
        }
        return conexion;
    }
}
