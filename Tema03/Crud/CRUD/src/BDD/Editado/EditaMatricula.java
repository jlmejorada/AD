package BDD.Editado;

import BDD.Consultas.ConsultasAlumnado;
import BDD.Consultas.ConsultasMatriculas;
import BDD.Transaccion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EditaMatricula {

    // Funcion que se encarga de editar la Matricula
    public static void editarMatricula(Connection conn, Scanner sc) throws ClassNotFoundException, SQLException {
        String modificar="";
        Statement stmt = null;

        int IdMatricula;
        int IdProfesorado ;
        int IdAlumnado;
        int Curso;
        String Asignatura="";

        ConsultasMatriculas.listadoMatriculas(conn);

        System.out.println("Inserte el ID de la Matricula que quieres modificar");
        IdMatricula = sc.nextInt();
        sc.nextLine();

        Transaccion.empezarTransaccion(conn);

        //Modificación del Id del Profesor
        System.out.println("¿Quiere modificar el idProfesorado?(Si, No)");
        modificar=sc.nextLine();

        if(modificar.toLowerCase().equals("Si".toLowerCase())) {
            stmt = conn.createStatement();
            System.out.println("¿Cuál es el nuevo idProfesorado?");
            IdProfesorado=sc.nextInt();
            sc.nextLine();
            stmt.executeUpdate("UPDATE Matricula SET idProfesor = '"+IdProfesorado+"' WHERE idMatricula = "+IdMatricula+";");
            System.out.println("Editado correctamente");

        }

        //Modificación del Id del Alumno
        System.out.println("¿Quiere modificar el idAlumnado?(Si, No)");
        modificar=sc.nextLine();

        if(modificar.toLowerCase().equals("Si".toLowerCase())) {
            stmt = conn.createStatement();
            System.out.println("¿Cuál es el nuevo idAlumnado?");
            IdAlumnado=sc.nextInt();
            sc.nextLine();
            stmt.executeUpdate("UPDATE Matricula SET idAlumnado = '"+IdAlumnado+"' WHERE idMatricula = "+IdMatricula+";");
            System.out.println("Editado correctamente");

        }

        //Modificación de la asignatura
        System.out.println("¿Quiere modificar la Asignatura?(Si, No)");
        modificar=sc.nextLine();

        if(modificar.toLowerCase().equals("Si".toLowerCase())) {
            stmt = conn.createStatement();
            System.out.println("¿Cuál es la nueva Asignatura?");
            Asignatura=sc.nextLine();
            stmt.executeUpdate("UPDATE Matricula SET Asignatura = '"+Asignatura+"' WHERE idMatricula = "+IdMatricula+";");
            System.out.println("Editado correctamente");

        }

        //Modificación del curso
        System.out.println("¿Quiere modificar el curso?(Si, No)");
        modificar=sc.nextLine();

        if(modificar.toLowerCase().equals("Si".toLowerCase())) {
            stmt = conn.createStatement();
            System.out.println("¿Cuál es el nuevo curso?");
            Curso=sc.nextInt();
            sc.nextLine();
            stmt.executeUpdate("UPDATE Curso SET Curso = '"+Curso+"' WHERE idMatricula = "+IdMatricula+";");
            System.out.println("Editado correctamente");

        }

        ConsultasMatriculas.listadoMatriculasPorID(conn, IdMatricula);

        System.out.println("¿Estas seguro de que quieres modificarlo?(Si, No)");
        modificar=sc.nextLine();

        if(modificar.toLowerCase().equals("Si".toLowerCase())) {
            Transaccion.confirmarTransaccion(conn);
        } else{
            Transaccion.cancelarTransaccion(conn);
        }
    }
}
