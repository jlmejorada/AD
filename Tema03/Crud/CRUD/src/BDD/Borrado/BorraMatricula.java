package BDD.Borrado;

import BDD.Consultas.ConsultasMatriculas;
import BDD.Consultas.ConsultasProfesor;
import BDD.Transaccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BorraMatricula {

    // Funcion que se encarga de borrar todos los campos
    public static void BorraTodos(Connection conn, Scanner sc) throws ClassNotFoundException, SQLException {
        String modificar = "";

        ConsultasMatriculas.listadoMatriculas(conn);

        Transaccion.empezarTransaccion(conn);

        try (Statement stmt = conn.createStatement()) {
            stmt.execute("DELETE FROM Matriculas");
            System.out.println("¿Estás seguro de que quieres eliminar todos los campos? (Si, No)");
            modificar = sc.nextLine();

            if ("si".equalsIgnoreCase(modificar)) {
                Transaccion.confirmarTransaccion(conn);
                System.out.println("Borrado correctamente.");
            } else {
                Transaccion.cancelarTransaccion(conn);
                System.out.println("No se ha borrado nada.");
            }

        } catch (SQLException e) {
            Transaccion.cancelarTransaccion(conn);
            System.out.println("Error durante el borrado: " + e.getMessage());
            throw e;
        }
    }

    // Funcion que se encarga de borrar por id
    public static void BorraPorId(Connection conn, Scanner sc) throws ClassNotFoundException, SQLException {
        String modificar = "";
        int IdMatricula;

        ConsultasMatriculas.listadoMatriculas(conn);

        System.out.println("Inserte el ID de la Matrícula que quiere borrar: ");
        IdMatricula = sc.nextInt();
        sc.nextLine();

        Transaccion.empezarTransaccion(conn);

        try (PreparedStatement conCampos = conn.prepareStatement("DELETE FROM Matriculas WHERE idMatricula = ?;")) {
            conCampos.setInt(1, IdMatricula);

            ConsultasMatriculas.listadoMatriculasPorID(conn, IdMatricula);

            System.out.println("¿Estás seguro de que lo quieres eliminar? (Si, No)");
            modificar = sc.nextLine();

            if ("si".equalsIgnoreCase(modificar)) {
                conCampos.executeUpdate();
                Transaccion.confirmarTransaccion(conn);
                System.out.println("Borrado correctamente.");
            } else {
                Transaccion.cancelarTransaccion(conn);
                System.out.println("No se ha borrado nada.");
            }
        } catch (SQLException e) {
            Transaccion.cancelarTransaccion(conn);
            System.out.println("Error durante el borrado: " + e.getMessage());
            throw e;
        }
    }

    // Funcion que se encarga de borrar por id de profesor
    public static void BorraPorIdProfesor(Connection conn, Scanner sc) throws ClassNotFoundException, SQLException {
        String modificar = "";
        int IdProfesor;

        ConsultasMatriculas.listadoMatriculas(conn);

        System.out.println("Inserte el ID del profesor de las matrículas que quiere borrar: ");
        IdProfesor = sc.nextInt();
        sc.nextLine();

        Transaccion.empezarTransaccion(conn);

        try (PreparedStatement conCampos = conn.prepareStatement("DELETE FROM Matriculas WHERE idProfesor = ?;")) {
            conCampos.setInt(1, IdProfesor);

            ConsultasMatriculas.listadoMatriculasPorIDProfesor(conn, IdProfesor);

            System.out.println("¿Estás seguro de que quieres eliminar todas las matrículas de este profesor? (Si, No)");
            modificar = sc.nextLine();

            if ("si".equalsIgnoreCase(modificar)) {
                conCampos.executeUpdate();
                Transaccion.confirmarTransaccion(conn);
                System.out.println("Borrado correctamente.");
            } else {
                Transaccion.cancelarTransaccion(conn);
                System.out.println("No se ha borrado nada.");
            }
        } catch (SQLException e) {
            Transaccion.cancelarTransaccion(conn);
            System.out.println("Error durante el borrado: " + e.getMessage());
            throw e;
        }
    }

    // Funcion que se encarga de borrar por id de alumno
    public static void BorraPorIdAlumno(Connection conn, Scanner sc) throws ClassNotFoundException, SQLException {
        String modificar = "";
        int IdAlumno;

        ConsultasMatriculas.listadoMatriculas(conn);

        System.out.println("Inserte el ID del alumno de las matrículas que quiere borrar: ");
        IdAlumno = sc.nextInt();
        sc.nextLine();

        Transaccion.empezarTransaccion(conn);

        try (PreparedStatement conCampos = conn.prepareStatement("DELETE FROM Matriculas WHERE idAlumnado = ?;")) {
            conCampos.setInt(1, IdAlumno);

            ConsultasMatriculas.listadoMatriculasPorIDAlumno(conn, IdAlumno);

            System.out.println("¿Estás seguro de que quieres eliminar todas las matrículas de este alumno? (Si, No)");
            modificar = sc.nextLine();

            if ("si".equalsIgnoreCase(modificar)) {
                conCampos.executeUpdate();
                Transaccion.confirmarTransaccion(conn);
                System.out.println("Borrado correctamente.");
            } else {
                Transaccion.cancelarTransaccion(conn);
                System.out.println("No se ha borrado nada.");
            }
        } catch (SQLException e) {
            Transaccion.cancelarTransaccion(conn);
            System.out.println("Error durante el borrado: " + e.getMessage());
            throw e;
        }
    }

    // Funcion que se encarga de borrar por asignatura
    public static void BorraPorAsignatura(Connection conn, Scanner sc) throws ClassNotFoundException, SQLException {
        String modificar = "";
        String asignatura;

        ConsultasMatriculas.listadoMatriculas(conn);

        System.out.println("Inserte el nombre de la asignatura de las matrículas que quiere borrar: ");
        asignatura = sc.nextLine();

        Transaccion.empezarTransaccion(conn);

        try (PreparedStatement conCampos = conn.prepareStatement("DELETE FROM Matriculas WHERE Asignatura = ?;")) {
            conCampos.setString(1, asignatura);

            ConsultasMatriculas.listadoMatriculasPorAsignatura(conn, asignatura);

            System.out.println("¿Estás seguro de que quieres eliminar todas las matrículas de esta asignatura? (Si, No)");
            modificar = sc.nextLine();

            if ("si".equalsIgnoreCase(modificar)) {
                int filasAfectadas = conCampos.executeUpdate();
                if (filasAfectadas > 0) {
                    Transaccion.confirmarTransaccion(conn);
                    System.out.println("Borrado correctamente.");
                } else {
                    Transaccion.cancelarTransaccion(conn);
                    System.out.println("No se encontraron matrículas asociadas a la asignatura.");
                }
            } else {
                Transaccion.cancelarTransaccion(conn);
                System.out.println("No se ha borrado nada.");
            }
        } catch (SQLException e) {
            Transaccion.cancelarTransaccion(conn);
            System.out.println("Error durante el borrado: " + e.getMessage());
            throw e;
        }
    }

    // Funcion que se encarga de borrar por curso
    public static void BorraPorCurso(Connection conn, Scanner sc) throws ClassNotFoundException, SQLException {
        String modificar = "";
        int curso;

        ConsultasMatriculas.listadoMatriculas(conn);

        System.out.println("Inserte el número del curso de las matrículas que quiere borrar: ");
        curso = sc.nextInt();
        sc.nextLine();
        Transaccion.empezarTransaccion(conn);

        try (PreparedStatement conCampos = conn.prepareStatement("DELETE FROM Matriculas WHERE Curso = ?;")) {
            conCampos.setInt(1, curso);

            ConsultasMatriculas.listadoMatriculasPorCurso(conn, curso);

            System.out.println("¿Estás seguro de que quieres eliminar todas las matrículas de este curso? (Si, No)");
            modificar = sc.nextLine();

            if ("si".equalsIgnoreCase(modificar)) {
                int filasAfectadas = conCampos.executeUpdate();
                if (filasAfectadas > 0) {
                    Transaccion.confirmarTransaccion(conn);
                    System.out.println("Borrado correctamente.");
                } else {
                    Transaccion.cancelarTransaccion(conn);
                    System.out.println("No se encontraron matrículas asociadas al curso.");
                }
            } else {
                Transaccion.cancelarTransaccion(conn);
                System.out.println("No se ha borrado nada.");
            }
        } catch (SQLException e) {
            Transaccion.cancelarTransaccion(conn);
            System.out.println("Error durante el borrado: " + e.getMessage());
            throw e;
        }
    }
}
