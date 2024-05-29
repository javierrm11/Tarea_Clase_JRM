package ejercicio;

import java.sql.Connection;
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

}
