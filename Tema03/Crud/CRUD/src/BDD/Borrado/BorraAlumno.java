package BDD.Borrado;

import BDD.Consultas.ConsultasAlumnado;
import BDD.Transaccion;

import java.sql.*;
import java.util.Scanner;

public class BorraAlumno
{
    // Funcion que se encarga de borrar todos los campos
    public static void BorraTodos(Connection conn, Scanner sc) throws ClassNotFoundException, SQLException {
        String modificar = "";

        ConsultasAlumnado.listadoAlumnado(conn);

        Transaccion.empezarTransaccion(conn);

        try (Statement stmt = conn.createStatement()) {
            System.out.println("¿Estas seguro de que quieres eliminar todos los campos?(Si, No)");
            modificar = sc.nextLine();

            if ("si".equalsIgnoreCase(modificar)) {
                stmt.execute("DELETE FROM Alumnado");
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

        int IdAlumno;

        ConsultasAlumnado.listadoAlumnado(conn);

        System.out.println("Inserte el ID del alumno que quiere borrar: ");
        IdAlumno = sc.nextInt();
        sc.nextLine();

        Transaccion.empezarTransaccion(conn);

        try (PreparedStatement conCampos = conn.prepareStatement("DELETE FROM Alumnado WHERE idAlumnado = ?;")) {
            conCampos.setInt(1, IdAlumno);

            ConsultasAlumnado.listadoAlumnadoPorId(conn, IdAlumno);

            System.out.println("¿Estas seguro de que lo quieres eliminar? (Si, No)");
            modificar = sc.nextLine();

            if ("si".equalsIgnoreCase(modificar)) {
                int filasAfectadas = conCampos.executeUpdate();
                if (filasAfectadas > 0) {
                    Transaccion.confirmarTransaccion(conn);
                    System.out.println("Borrado correctamente");
                } else {
                    Transaccion.cancelarTransaccion(conn);
                    System.out.println("No se encontró ningún alumno con el ID proporcionado");
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

        ConsultasAlumnado.listadoAlumnado(conn);

        System.out.println("Inserte el nombre del alumno que quiere borrar: ");
        nombre = sc.nextLine();

        Transaccion.empezarTransaccion(conn);

        try (PreparedStatement conCampos = conn.prepareStatement("DELETE FROM Alumnado WHERE Nombre = ?;")) {
            conCampos.setString(1, nombre);

            ConsultasAlumnado.listadoAlumnadoPorNombre(conn, nombre);

            System.out.println("¿Estás seguro de que lo quieres eliminar? (Si, No)");
            modificar = sc.nextLine();

            if ("si".equalsIgnoreCase(modificar)) {
                int filasAfectadas = conCampos.executeUpdate();
                if (filasAfectadas > 0) {
                    Transaccion.confirmarTransaccion(conn);
                    System.out.println("Borrado correctamente");
                } else {
                    Transaccion.cancelarTransaccion(conn);
                    System.out.println("No se encontró ningún alumno con el nombre proporcionado");
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

        ConsultasAlumnado.listadoAlumnado(conn);

        System.out.println("Inserte los apellidos del alumno que quiere borrar: ");
        apellidos = sc.nextLine();

        Transaccion.empezarTransaccion(conn);

        try (PreparedStatement conCampos = conn.prepareStatement("DELETE FROM Alumnado WHERE Apellidos = ?;")) {
            conCampos.setString(1, apellidos);

            ConsultasAlumnado.listadoAlumnadoPorApellidos(conn, apellidos);

            System.out.println("¿Estás seguro de que lo quieres eliminar? (Si, No)");
            modificar = sc.nextLine();

            if ("si".equalsIgnoreCase(modificar)) {
                int filasAfectadas = conCampos.executeUpdate();
                if (filasAfectadas > 0) {
                    Transaccion.confirmarTransaccion(conn);
                    System.out.println("Borrado correctamente");
                } else {
                    Transaccion.cancelarTransaccion(conn);
                    System.out.println("No se encontró ningún alumno con los apellidos proporcionados");
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

        ConsultasAlumnado.listadoAlumnado(conn);

        System.out.println("Cuál es la Fecha de Nacimiento del alumno que quiere borrar (ej. 1974-12-11): ");
        fechaNac = sc.nextLine();

        Transaccion.empezarTransaccion(conn);

        try (PreparedStatement conCampos = conn.prepareStatement("DELETE FROM Alumnado WHERE FechaNacimiento = ?;")) {
            conCampos.setDate(1, Date.valueOf(fechaNac));

            ConsultasAlumnado.listadoAlumnadoPorFecha(conn, fechaNac);

            System.out.println("¿Estás seguro de que lo quieres eliminar? (Si, No)");
            modificar = sc.nextLine();

            if ("si".equalsIgnoreCase(modificar)) {
                int filasAfectadas = conCampos.executeUpdate();
                if (filasAfectadas > 0) {
                    Transaccion.confirmarTransaccion(conn);
                    System.out.println("Borrado correctamente");
                } else {
                    Transaccion.cancelarTransaccion(conn);
                    System.out.println("No se encontró ningún alumno con la fecha de nacimiento proporcionada");
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
