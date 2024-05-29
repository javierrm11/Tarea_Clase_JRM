package ejercicio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection cn = Conexion.conectar();

        Aplicacion ap = new Aplicacion(cn);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Agregar Dieta");
            System.out.println("2. Mostrar Diedas de Informatica");
            System.out.println("3. Incrementar Precio");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    ap.agregaDieta();
                    break;
                case 2:
                    ap.mostrarDietasDeInformatica();
                    break;
                case 3:
                    ap.incrementarPrecioVentas();
                    break;
                case 4:
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida.");
            }

        }
    }
}
