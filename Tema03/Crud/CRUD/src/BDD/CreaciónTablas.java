package BDD;

import Main.Main;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreaciónTablas {

    public static boolean creaTablaProfesor() {
        boolean seCrea = false;
        PreparedStatement creaTabla = null;
        try {
            creaTabla = Main.conn.prepareStatement
                    ("CREATE TABLE Profesores (\n" +
                    "    idProfesor INT PRIMARY KEY,\n" +
                    "    Nombre VARCHAR(45) NOT NULL,\n" +
                    "    Apellidos VARCHAR(45) NOT NULL,\n" +
                    "    FechaNacimiento DATE NOT NULL,\n" +
                    "    Antiguedad INT NOT NULL);");
            creaTabla.executeUpdate();
            seCrea = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                creaTabla.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return seCrea;
    }

    public static boolean creaTablaAlumnado() {
        boolean seCrea = false;
        PreparedStatement creaTabla = null;
        try {
            creaTabla = Main.conn.prepareStatement("CREATE TABLE Alumnado (\n" +
                    "    idAlumnado INT PRIMARY KEY,\n" +
                    "    Nombre VARCHAR(45) NOT NULL,\n" +
                    "    Apellidos VARCHAR(45) NOT NULL,\n" +
                    "    FechaNacimiento DATE NOT NULL);");
            creaTabla.executeUpdate();
            seCrea = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                creaTabla.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return seCrea;
    }

    public static boolean creaTablaMatricula() {
        boolean seCrea = false;
        PreparedStatement creaTabla=null;
        try {
            creaTabla = Main.conn.prepareStatement("CREATE TABLE Matriculas (" +
                    "    idMatricula INT PRIMARY KEY, " +
                    "    idProfesor INT NOT NULL, " +
                    "    idAlumnado INT NOT NULL, " +
                    "    Asignatura VARCHAR(45) NOT NULL, " +
                    "    Curso INT NOT NULL, " +
                    "    FOREIGN KEY (idProfesor) REFERENCES Profesores(idProfesor), " +
                    "    FOREIGN KEY (idAlumnado) REFERENCES Alumnado(idAlumnado))");
            creaTabla.executeUpdate();
            seCrea = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                creaTabla.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return seCrea;
    }
}
