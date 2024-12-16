package BDD;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DropTabla {

    // Funcion que se encarga de dropear todas las tablas
    public static void DropTodos(Connection conn, Scanner sc) throws ClassNotFoundException, SQLException {

        DropMatricula(conn, sc);

        DropAlumnado(conn, sc);

        DropProfesor(conn, sc);

    }

    // Funcion que se encarga de dropear la tabla matricula
    public static void DropMatricula(Connection conn, Scanner sc) throws ClassNotFoundException, SQLException {
        String modificar = "";

        Transaccion.empezarTransaccion(conn);

        try (PreparedStatement conCampos = conn.prepareStatement("DROP TABLE Matriculas;;")) {

            System.out.println("¿Estás seguro de que lo quieres eliminar? (Si, No)");
            modificar = sc.nextLine();

            if ("si".equalsIgnoreCase(modificar)) {
                int filasAfectadas = conCampos.executeUpdate();
                if (filasAfectadas >= 0) {
                    Transaccion.confirmarTransaccion(conn);
                    System.out.println("Borrado correctamente");
                } else {
                    Transaccion.cancelarTransaccion(conn);
                    System.out.println("No se pudo borrar la tabla");
                }
            } else {
                Transaccion.cancelarTransaccion(conn);
                System.out.println("No se ha borrado");
            }
        } catch (SQLException e) {
            Transaccion.cancelarTransaccion(conn);
            throw e;
        }
    }

    public static void DropProfesor(Connection conn, Scanner sc) throws ClassNotFoundException, SQLException {
        String modificar = "";

        Transaccion.empezarTransaccion(conn);

        try (PreparedStatement conCampos = conn.prepareStatement("DROP TABLE Profesores;")) {

            System.out.println("¿Estás seguro de que lo quieres eliminar? (Si, No)");
            modificar = sc.nextLine();

            if ("si".equalsIgnoreCase(modificar)) {
                int filasAfectadas = conCampos.executeUpdate();
                if (filasAfectadas >= 0) {
                    Transaccion.confirmarTransaccion(conn);
                    System.out.println("Borrado correctamente");
                } else {
                    Transaccion.cancelarTransaccion(conn);
                    System.out.println("No se pudo borrar la tabla");
                }
            } else {
                Transaccion.cancelarTransaccion(conn);
                System.out.println("No se ha borrado");
            }
        } catch (SQLException e) {
            Transaccion.cancelarTransaccion(conn);
            throw e;
        }
    }

    public static void DropAlumnado(Connection conn, Scanner sc) throws ClassNotFoundException, SQLException {
        String modificar = "";

        Transaccion.empezarTransaccion(conn);

        try (PreparedStatement conCampos = conn.prepareStatement("DROP TABLE Alumnado;")) {

            System.out.println("¿Estás seguro de que lo quieres eliminar? (Si, No)");
            modificar = sc.nextLine();

            if ("si".equalsIgnoreCase(modificar)) {
                int filasAfectadas = conCampos.executeUpdate();
                if (filasAfectadas >= 0) {
                    Transaccion.confirmarTransaccion(conn);
                    System.out.println("Borrado correctamente");
                } else {
                    Transaccion.cancelarTransaccion(conn);
                    System.out.println("No se pudo borrar la tabla");
                }
            } else {
                Transaccion.cancelarTransaccion(conn);
                System.out.println("No se ha borrado");
            }
        } catch (SQLException e) {
            Transaccion.cancelarTransaccion(conn);
            throw e;
        }
    }
}
