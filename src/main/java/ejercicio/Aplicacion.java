package ejercicio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Aplicacion {
    private Statement stm;

    public Aplicacion(Connection cn) throws SQLException {
        this.stm = cn.createStatement();
    }

    Scanner sc = new Scanner(System.in);

    public void agregaDieta() throws SQLException {
        System.out.println("Vamos a introducir una nueva dieta");
        System.out.println("Introduce un id");
        int id = sc.nextInt();

        System.out.println("Introduce el nombre del empleado");
        String empleado = sc.next();

        System.out.println("Introduce el departamento");
        String departamento = sc.next();

        System.out.println("Introduce la cantidad");
        int cantidad = sc.nextInt();

        System.out.println("Introduce el concepto");
        String concepto = sc.next();

        String introduceDieta = "Insert into Dieta (id, " +
                "empleado, departamento, cantidad, concepto) values " +
                "("+id+", '"+empleado+"', '"+departamento +"'," +
                " "+cantidad+", '"+concepto+"');";
        try {
            stm.executeUpdate(introduceDieta);
            System.out.println("Dieta introducida con exito");
            System.out.println(id + " - " + empleado + " - " + departamento + " - " + cantidad + " - " + concepto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public void mostrarDietasDeInformatica() throws SQLException {
        System.out.println("Vamos a mostrar todas las Dietas de Informatica mayores de 30€");

        String sentencia = "SELECT * FROM Dieta Where departamento = 'Informatica' And cantidad > 30";
        try {
            ResultSet rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                String id = rs.getString("id");
                String empleado = rs.getString("empleado");
                String departamento = rs.getString("departamento");
                String cantidad = rs.getString("cantidad");
                String concepto = rs.getString("concepto");

                System.out.println("ID: "+ id + " | Empleado: "+ empleado + " | Departamento: "+ departamento + " | Cantidad: "+ cantidad + " | Concepto: "+ concepto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void incrementarPrecioVentas() throws SQLException {
        System.out.println("Vamos a proceder a subir un 10% el precio de las Dietas de Ventas");

        String sentencia = "UPDATE Dieta SET cantidad = cantidad * 1.10 WHERE departamento = 'Ventas'";
        try {
            stm.executeUpdate(sentencia);
            System.out.println("Se ha ejecutado Correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
