package BDD.Insercciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertaAlumno {

    public static boolean insertarAlumno(Connection conn, Scanner sc) {

        String insert = "";

        boolean insertado = false;
        int idAlumno = 0;
        String nombre = "";
        String apellidos = "";
        String fecha = "";

        System.out.println("Introduzca el id del alumno: ");
        idAlumno = sc.nextInt();
        sc.nextLine();

        System.out.println("Introduzca el nombre: ");
        nombre = sc.nextLine();

        System.out.println("Introduzca el apellido: ");
        apellidos = sc.nextLine();

        System.out.println("Introduzca la fecha con el formato (1974-12-11): ");
        fecha = sc.nextLine();

        try {

            insert = "INSERT INTO Alumnado (idAlumnado, Nombre, Apellidos, FechaNacimiento) VALUES (?, ?, ?, ?);";

            PreparedStatement insertAlumno= conn.prepareStatement(insert);

            insertAlumno.setInt(1, idAlumno);
            insertAlumno.setString(2, nombre);
            insertAlumno.setString(3, apellidos);
            insertAlumno.setString(4, fecha);

            insertAlumno.executeUpdate();

            insertado = true;

            System.out.println();

            insertAlumno.close();


            return insertado;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fallo en la inserción");

        }
        return insertado;
    }
}
