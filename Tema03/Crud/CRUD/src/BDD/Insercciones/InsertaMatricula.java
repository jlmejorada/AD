package BDD.Insercciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertaMatricula {

    public static boolean insertarMatricula(Connection conn, Scanner sc) {

        String insert = "";

        boolean insertado = false;
        int idMatricula = 0;
        int idProfesor = 0;
        int idAlumno = 0;
        String asignatura = "";
        int curso = 0;

        System.out.println("Introduzca un nuevo id: ");
        idMatricula = sc.nextInt();

        System.out.println("Introduzca el id del profesor: ");
        idProfesor = sc.nextInt();
        sc.nextLine();

        System.out.println("Introduzca el id del alumno: ");
        idAlumno = sc.nextInt();
        sc.nextLine();

        System.out.println("Introduzca la asignatura: ");
        asignatura = sc.nextLine();

        System.out.println("Introduzca el curso: ");
        curso = sc.nextInt();

        try {

            insert = "INSERT INTO Matriculas (idMatricula, idProfesor, idAlumnado, Asignatura, Curso) VALUES (?, ?, ?, ?, ?);";

            PreparedStatement insertMatricula = conn.prepareStatement(insert);

            insertMatricula.setInt(1, idMatricula);
            insertMatricula.setInt(2, idProfesor);
            insertMatricula.setInt(3, idAlumno);
            insertMatricula.setString(4, asignatura);
            insertMatricula.setInt(5, curso);

            insertMatricula.executeUpdate();

            insertado = true;

            System.out.println();

            insertMatricula.close();


            return insertado;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fallo en la inserción");

        }
        return insertado;
    }
}