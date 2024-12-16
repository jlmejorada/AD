package BDD.Insercciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertaProfesor {

    public static boolean insertarProfesor(Connection conn, Scanner sc) {

        String insert = "";

        boolean insertado = false;
        int idProfesor = 0;
        String nombre = "";
        String apellidos = "";
        String fecha = "";
        int antiguedad = 0;

        System.out.println("Introduzca el id del profesor: ");
        idProfesor = sc.nextInt();
        sc.nextLine();

        System.out.println("Introduzca el nombre: ");
        nombre = sc.nextLine();

        System.out.println("Introduzca el apellido: ");
        apellidos = sc.nextLine();

        System.out.println("Introduzca la fecha con el formato (1974-12-11): ");
        fecha = sc.nextLine();

        System.out.println("Introduzca la antiguedad: ");
        antiguedad = sc.nextInt();

        try {

            insert = "INSERT INTO Profesores (idProfesor, Nombre, Apellidos, FechaNacimiento, Antiguedad) VALUES (?, ?, ?, ?, ?);";

            PreparedStatement insertProfesor = conn.prepareStatement(insert);

            insertProfesor.setInt(1, idProfesor);
            insertProfesor.setString(2, nombre);
            insertProfesor.setString(3, apellidos);
            insertProfesor.setString(4, fecha);
            insertProfesor.setInt(5, antiguedad);

            insertProfesor.executeUpdate();

            insertado = true;

            System.out.println();

            insertProfesor.close();


            return insertado;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fallo en la inserción");

        }
        return insertado;
    }
}
