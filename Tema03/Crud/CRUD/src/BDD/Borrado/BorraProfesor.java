package BDD.Borrado;

import BDD.Consultas.ConsultasAlumnado;
import BDD.Consultas.ConsultasProfesor;
import BDD.Transaccion;

import java.sql.*;
import java.util.Scanner;

public class BorraProfesor {

    // Funcion que se encarga de borrar todos los campos
    public static void BorraTodos(Connection conn, Scanner sc) throws ClassNotFoundException, SQLException {
        String modificar = "";

        ConsultasProfesor.listadoProfesores(conn);

        Transaccion.empezarTransaccion(conn);

        try (Statement stmt = conn.createStatement()) {
            System.out.println("¿Estás seguro de que quieres eliminar todos los campos? (Si, No)");
            modificar = sc.nextLine();

            if ("si".equalsIgnoreCase(modificar)) {
                stmt.execute("DELETE FROM Profesores");
                Transaccion.confirmarTransaccion(conn);
                System.out.println("Borrado correctamente");
            } else {
                Transaccion.cancelarTransaccion(conn);
                System.out.println("No se ha borrado");
            }
        } catch (SQLException e) {
            Transaccion.cancelarTransaccion(conn);
            throw e;
        }
    }

    // Funcion que se encarga de borrar por id
    public static void BorraPorId(Connection conn, Scanner sc) throws ClassNotFoundException, SQLException {
        String modificar = "";

        int IdProfesor;

        ConsultasProfesor.listadoProfesores(conn);

        System.out.println("Inserte el ID del profesor que quiere borrar: ");
        IdProfesor = sc.nextInt();
        sc.nextLine();

        Transaccion.empezarTransaccion(conn);

        try (PreparedStatement conCampos = conn.prepareStatement("DELETE FROM Profesores WHERE idProfesor = ?;")) {
            conCampos.setInt(1, IdProfesor);

            ConsultasProfesor.listadoProfesoresPorId(conn, IdProfesor);

            System.out.println("¿Estás seguro de que lo quieres eliminar? (Si, No)");
            modificar = sc.nextLine();

            if ("si".equalsIgnoreCase(modificar)) {
                int filasAfectadas = conCampos.executeUpdate();
                if (filasAfectadas > 0) {
                    Transaccion.confirmarTransaccion(conn);
                    System.out.println("Borrado correctamente");
                } else {
                    Transaccion.cancelarTransaccion(conn);
                    System.out.println("No se encontró ningún profesor con el ID proporcionado");
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

    // Funcion que se encarga de borrar por nombre
    public static void BorraPorNombre(Connection conn, Scanner sc) throws ClassNotFoundException, SQLException {
        String modificar = "";

        String nombre;

        ConsultasProfesor.listadoProfesores(conn);

        System.out.println("Inserte el nombre del profesor que quiere borrar: ");
        nombre = sc.nextLine();

        Transaccion.empezarTransaccion(conn);

        try (PreparedStatement conCampos = conn.prepareStatement("DELETE FROM Profesores WHERE Nombre = ?;")) {
            conCampos.setString(1, nombre);

            ConsultasProfesor.listadoProfesoresPorNombre(conn, nombre);

            System.out.println("¿Estás seguro de que lo quieres eliminar? (Si, No)");
            modificar = sc.nextLine();

            if ("si".equalsIgnoreCase(modificar)) {
                int filasAfectadas = conCampos.executeUpdate();
                if (filasAfectadas > 0) {
                    Transaccion.confirmarTransaccion(conn);
                    System.out.println("Borrado correctamente");
                } else {
                    Transaccion.cancelarTransaccion(conn);
                    System.out.println("No se encontró ningún profesor con el nombre proporcionado");
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

    // Funcion que se encarga de borrar por apellidos
    public static void BorraPorApellidos(Connection conn, Scanner sc) throws ClassNotFoundException, SQLException {
        String modificar = "";

        String apellidos;

        ConsultasProfesor.listadoProfesores(conn);

        System.out.println("Inserte los apellidos del profesor que quiere borrar: ");
        apellidos = sc.nextLine();

        Transaccion.empezarTransaccion(conn);

        try (PreparedStatement conCampos = conn.prepareStatement("DELETE FROM Profesores WHERE Apellidos = ?;")) {
            conCampos.setString(1, apellidos);

            ConsultasProfesor.listadoProfesoresPorApellidos(conn, apellidos);

            System.out.println("¿Estás seguro de que lo quieres eliminar? (Si, No)");
            modificar = sc.nextLine();

            if ("si".equalsIgnoreCase(modificar)) {
                int filasAfectadas = conCampos.executeUpdate();
                if (filasAfectadas > 0) {
                    Transaccion.confirmarTransaccion(conn);
                    System.out.println("Borrado correctamente");
                } else {
                    Transaccion.cancelarTransaccion(conn);
                    System.out.println("No se encontró ningún profesor con los apellidos proporcionados");
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

    // Funcion que se encarga de borrar por FechaNacimiento
    public static void BorraPorFechaNacimiento(Connection conn, Scanner sc) throws ClassNotFoundException, SQLException {
        String modificar = "";

        String fechaNac;

        ConsultasProfesor.listadoProfesores(conn);

        System.out.println("¿Cuál es la Fecha de Nacimiento del profesor que quiere borrar (ej. 1974-12-11)? ");
        fechaNac = sc.nextLine();

        Transaccion.empezarTransaccion(conn);

        try (PreparedStatement conCampos = conn.prepareStatement("DELETE FROM Profesores WHERE FechaNacimiento = ?;")) {
            conCampos.setDate(1, Date.valueOf(fechaNac));

            ConsultasProfesor.listadoProfesoresPorFecha(conn, fechaNac);

            System.out.println("¿Estás seguro de que lo quieres eliminar? (Si, No)");
            modificar = sc.nextLine();

            if ("si".equalsIgnoreCase(modificar)) {
                int filasAfectadas = conCampos.executeUpdate();
                if (filasAfectadas > 0) {
                    Transaccion.confirmarTransaccion(conn);
                    System.out.println("Borrado correctamente");
                } else {
                    Transaccion.cancelarTransaccion(conn);
                    System.out.println("No se encontró ningún profesor con la fecha de nacimiento proporcionada");
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

    // Funcion que se encarga de borrar por antiguedad
    public static void BorraPorAntiguedad(Connection conn, Scanner sc) throws ClassNotFoundException, SQLException {
        String modificar = "";

        int ant;

        ConsultasProfesor.listadoProfesores(conn);

        System.out.println("Inserte la antigüedad del profesor que quiere borrar: ");
        ant = sc.nextInt();
        sc.nextLine();

        Transaccion.empezarTransaccion(conn);

        try (PreparedStatement conCampos = conn.prepareStatement("DELETE FROM Profesores WHERE Antiguedad = ?;")) {
            conCampos.setInt(1, ant);

            ConsultasProfesor.listadoProfesoresPorAntiguedad(conn, ant);

            System.out.println("¿Estás seguro de que lo quieres eliminar? (Si, No)");
            modificar = sc.nextLine();

            if ("si".equalsIgnoreCase(modificar)) {
                int filasAfectadas = conCampos.executeUpdate();
                if (filasAfectadas > 0) {
                    Transaccion.confirmarTransaccion(conn);
                    System.out.println("Borrado correctamente");
                } else {
                    Transaccion.cancelarTransaccion(conn);
                    System.out.println("No se encontró ningún profesor con la antigüedad proporcionada");
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
