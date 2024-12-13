package BDD.Consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasMatriculas {

    public static void listadoMatriculas(Connection conn) {
        ResultSet lista = null;
        PreparedStatement listaCompleta = null;
        try {
            listaCompleta = conn.prepareStatement("SELECT * FROM Matriculas");
            lista = listaCompleta.executeQuery();
            while (lista.next()) {
                System.out.println("ID: " + lista.getInt("idMatricula"));
                System.out.println("ID Alumno: " + lista.getInt("idProfesor"));
                System.out.println("ID Profesor: " + lista.getInt("idAlumnado"));
                System.out.println("Asignatura: " + lista.getString("Asignatura"));
                System.out.println("Curso: " + lista.getInt("Curso"));
                System.out.println("-----------------------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                lista.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public static void listadoMatriculasPorID(Connection conn, int compara) {
        ResultSet lista = null;
        PreparedStatement listaCompleta = null;
        try {
            listaCompleta = conn.prepareStatement("SELECT * FROM Matriculas WHERE idMatricula = ?");
            listaCompleta.setInt(1, compara);
            lista = listaCompleta.executeQuery();
            while (lista.next()) {
                System.out.println("ID: " + lista.getInt("idMatricula"));
                System.out.println("ID Alumno: " + lista.getInt("idProfesor"));
                System.out.println("ID Profesor: " + lista.getInt("idAlumnado"));
                System.out.println("Asignatura: " + lista.getString("Asignatura"));
                System.out.println("Curso: " + lista.getInt("Curso"));
                System.out.println("-----------------------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                lista.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public static void listadoMatriculasPorIDProfesor(Connection conn, int compara) {
        ResultSet lista = null;
        PreparedStatement listaCompleta = null;
        try {
            listaCompleta = conn.prepareStatement("SELECT * FROM Matriculas WHERE idProfesor = ?");
            listaCompleta.setInt(1, compara);
            lista = listaCompleta.executeQuery();
            while (lista.next()) {
                System.out.println("ID: " + lista.getInt("idMatricula"));
                System.out.println("ID Alumno: " + lista.getInt("idProfesor"));
                System.out.println("ID Profesor: " + lista.getInt("idAlumnado"));
                System.out.println("Asignatura: " + lista.getString("Asignatura"));
                System.out.println("Curso: " + lista.getInt("Curso"));
                System.out.println("-----------------------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                lista.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public static void listadoMatriculasPorIDAlumno(Connection conn, int compara) {
        ResultSet lista = null;
        PreparedStatement listaCompleta = null;
        try {
            listaCompleta = conn.prepareStatement("SELECT * FROM Matriculas WHERE idAlumnado = ?");
            listaCompleta.setInt(1, compara);
            lista = listaCompleta.executeQuery();
            while (lista.next()) {
                System.out.println("ID: " + lista.getInt("idMatricula"));
                System.out.println("ID Alumno: " + lista.getInt("idProfesor"));
                System.out.println("ID Profesor: " + lista.getInt("idAlumnado"));
                System.out.println("Asignatura: " + lista.getString("Asignatura"));
                System.out.println("Curso: " + lista.getInt("Curso"));
                System.out.println("-----------------------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                lista.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public static void listadoMatriculasPorAsignatura(Connection conn, String compara) {
        ResultSet lista = null;
        PreparedStatement listaCompleta = null;
        try {
            listaCompleta = conn.prepareStatement("SELECT * FROM Matriculas WHERE Asignatura = ?");
            listaCompleta.setString(1, compara);
            lista = listaCompleta.executeQuery();
            while (lista.next()) {
                System.out.println("ID: " + lista.getInt("idMatricula"));
                System.out.println("ID Alumno: " + lista.getInt("idProfesor"));
                System.out.println("ID Profesor: " + lista.getInt("idAlumnado"));
                System.out.println("Asignatura: " + lista.getString("Asignatura"));
                System.out.println("Curso: " + lista.getInt("Curso"));
                System.out.println("-----------------------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                lista.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public static void listadoMatriculasPorCurso(Connection conn, int compara) {
        ResultSet lista = null;
        PreparedStatement listaCompleta = null;
        try {
            listaCompleta = conn.prepareStatement("SELECT * FROM Matriculas WHERE Curso = ?");
            listaCompleta.setInt(1, compara);
            lista = listaCompleta.executeQuery();
            while (lista.next()) {
                System.out.println("ID: " + lista.getInt("idMatricula"));
                System.out.println("ID Alumno: " + lista.getInt("idProfesor"));
                System.out.println("ID Profesor: " + lista.getInt("idAlumnado"));
                System.out.println("Asignatura: " + lista.getString("Asignatura"));
                System.out.println("Curso: " + lista.getInt("Curso"));
                System.out.println("-----------------------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                lista.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

}
