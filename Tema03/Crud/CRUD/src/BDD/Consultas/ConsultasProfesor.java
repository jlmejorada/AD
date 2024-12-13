package BDD.Consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasProfesor {

    public static void listadoProfesores(Connection conn) {
        ResultSet lista = null;
        PreparedStatement listaCompleta = null;
        try {
            listaCompleta = conn.prepareStatement("SELECT * FROM Profesores");
            lista = listaCompleta.executeQuery();
            while(lista.next()) {
                System.out.println("ID: " + lista.getInt("idProfesor") + " ");
                System.out.println("Nombre: " + lista.getString("Nombre"));
                System.out.println("Apellido: " + lista.getString("Apellidos"));
                System.out.println("Fecha de Nacimiento: " + lista.getDate("FechaNacimiento"));
                System.out.println("Antigüedad: " + lista.getInt("Antiguedad"));
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

    public static void listadoProfesoresPorId(Connection conn, int compara) {
        ResultSet lista = null;
        PreparedStatement listaCompleta = null;
        try {
            listaCompleta = conn.prepareStatement("SELECT * FROM Profesores WHERE idProfesor = ?");
            listaCompleta.setInt(1, compara);
            lista = listaCompleta.executeQuery();
            while(lista.next()) {
                System.out.println("ID: " + lista.getInt("idProfesor") + " ");
                System.out.println("Nombre: " + lista.getString("Nombre"));
                System.out.println("Apellido: " + lista.getString("Apellidos"));
                System.out.println("Fecha de Nacimiento: " + lista.getDate("FechaNacimiento"));
                System.out.println("Antigüedad: " + lista.getInt("Antiguedad"));
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

    public static void listadoProfesoresPorNombre(Connection conn, String compara) {
        ResultSet lista = null;
        PreparedStatement listaCompleta = null;
        try {
            listaCompleta = conn.prepareStatement("SELECT * FROM Profesores WHERE Nombre = ?");
            listaCompleta.setString(1, compara);
            lista = listaCompleta.executeQuery();
            while(lista.next()) {
                System.out.println("ID: " + lista.getInt("idProfesor") + " ");
                System.out.println("Nombre: " + lista.getString("Nombre"));
                System.out.println("Apellido: " + lista.getString("Apellidos"));
                System.out.println("Fecha de Nacimiento: " + lista.getDate("FechaNacimiento"));
                System.out.println("Antigüedad: " + lista.getInt("Antiguedad"));
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

    public static void listadoProfesoresPorApellidos(Connection conn, String compara) {
        ResultSet lista = null;
        PreparedStatement listaCompleta = null;
        try {
            listaCompleta = conn.prepareStatement("SELECT * FROM Profesores WHERE Apellidos = ?");
            listaCompleta.setString(1, compara);
            lista = listaCompleta.executeQuery();
            while(lista.next()) {
                System.out.println("ID: " + lista.getInt("idProfesor") + " ");
                System.out.println("Nombre: " + lista.getString("Nombre"));
                System.out.println("Apellido: " + lista.getString("Apellidos"));
                System.out.println("Fecha de Nacimiento: " + lista.getDate("FechaNacimiento"));
                System.out.println("Antigüedad: " + lista.getInt("Antiguedad"));
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

    public static void listadoProfesoresPorFecha(Connection conn, String compara) {
        ResultSet lista = null;
        PreparedStatement listaCompleta = null;
        try {
            listaCompleta = conn.prepareStatement("SELECT * FROM Profesores WHERE FechaNacimiento = ?");
            listaCompleta.setString(1, compara);
            lista = listaCompleta.executeQuery();
            while(lista.next()) {
                System.out.println("ID: " + lista.getInt("idProfesor") + " ");
                System.out.println("Nombre: " + lista.getString("Nombre"));
                System.out.println("Apellido: " + lista.getString("Apellidos"));
                System.out.println("Fecha de Nacimiento: " + lista.getDate("FechaNacimiento"));
                System.out.println("Antigüedad: " + lista.getInt("Antiguedad"));
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

    public static void listadoProfesoresPorAntiguedad(Connection conn, int compara) {
        ResultSet lista = null;
        PreparedStatement listaCompleta = null;
        try {
            listaCompleta = conn.prepareStatement("SELECT * FROM Profesores WHERE Antiguedad = ?");
            listaCompleta.setInt(1, compara);
            lista = listaCompleta.executeQuery();
            while(lista.next()) {
                System.out.println("ID: " + lista.getInt("idProfesor") + " ");
                System.out.println("Nombre: " + lista.getString("Nombre"));
                System.out.println("Apellido: " + lista.getString("Apellidos"));
                System.out.println("Fecha de Nacimiento: " + lista.getDate("FechaNacimiento"));
                System.out.println("Antigüedad: " + lista.getInt("Antiguedad"));
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