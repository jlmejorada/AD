package BDD.Consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasAlumnado {

    public static void listadoAlumnado(Connection conn) {
        ResultSet lista = null;
        PreparedStatement listaCompleta = null;
        try {
            listaCompleta = conn.prepareStatement("SELECT * FROM Alumnado");
            lista = listaCompleta.executeQuery();
            while (lista.next()) {
                System.out.println("ID: " + lista.getInt("idAlumnado") + " ");
                System.out.println("Nombre: " + lista.getString("Nombre"));
                System.out.println("Apellido: " + lista.getString("Apellidos"));
                System.out.println("Fecha de Nacimiento: " + lista.getDate("FechaNacimiento"));
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

    public static void listadoAlumnadoPorId(Connection conn, int compara) {
        ResultSet lista = null;
        PreparedStatement listaCompleta = null;
        try {
            listaCompleta = conn.prepareStatement("SELECT * FROM Alumnado WHERE idAlumnado = ?");
            listaCompleta.setInt(1, compara);
            lista = listaCompleta.executeQuery();
            while (lista.next()) {
                System.out.println("ID: " + lista.getInt("idAlumnado") + " ");
                System.out.println("Nombre: " + lista.getString("Nombre"));
                System.out.println("Apellido: " + lista.getString("Apellidos"));
                System.out.println("Fecha de Nacimiento: " + lista.getDate("FechaNacimiento"));
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

    public static void listadoAlumnadoPorNombre(Connection conn, String compara) {
        ResultSet lista = null;
        PreparedStatement listaCompleta = null;
        try {
            listaCompleta = conn.prepareStatement("SELECT * FROM Alumnado WHERE Nombre = ?");
            listaCompleta.setString(1, compara);
            lista = listaCompleta.executeQuery();
            while (lista.next()) {
                System.out.println("ID: " + lista.getInt("idAlumnado") + " ");
                System.out.println("Nombre: " + lista.getString("Nombre"));
                System.out.println("Apellido: " + lista.getString("Apellidos"));
                System.out.println("Fecha de Nacimiento: " + lista.getDate("FechaNacimiento"));
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

    public static void listadoAlumnadoPorApellidos(Connection conn, String compara) {
        ResultSet lista = null;
        PreparedStatement listaCompleta = null;
        try {
            listaCompleta = conn.prepareStatement("SELECT * FROM Alumnado WHERE Apellidos = ?");
            listaCompleta.setString(1, compara);
            lista = listaCompleta.executeQuery();
            while (lista.next()) {
                System.out.println("ID: " + lista.getInt("idAlumnado") + " ");
                System.out.println("Nombre: " + lista.getString("Nombre"));
                System.out.println("Apellido: " + lista.getString("Apellidos"));
                System.out.println("Fecha de Nacimiento: " + lista.getDate("FechaNacimiento"));
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

    public static void listadoAlumnadoPorFecha(Connection conn, String compara) {
        ResultSet lista = null;
        PreparedStatement listaCompleta = null;
        try {
            listaCompleta = conn.prepareStatement("SELECT * FROM Alumnado WHERE FechaNacimiento = ?");
            listaCompleta.setString(1, compara);
            lista = listaCompleta.executeQuery();
            while (lista.next()) {
                System.out.println("ID: " + lista.getInt("idAlumnado") + " ");
                System.out.println("Nombre: " + lista.getString("Nombre"));
                System.out.println("Apellido: " + lista.getString("Apellidos"));
                System.out.println("Fecha de Nacimiento: " + lista.getDate("FechaNacimiento"));
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