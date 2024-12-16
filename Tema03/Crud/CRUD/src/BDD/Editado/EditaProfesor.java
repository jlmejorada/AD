package BDD.Editado;

import BDD.Consultas.ConsultasAlumnado;
import BDD.Consultas.ConsultasProfesor;
import BDD.Transaccion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EditaProfesor {

    // Funcion que se encarga de editar el profesor
    public static void editarProfesor(Connection conn, Scanner sc) throws ClassNotFoundException, SQLException {
        String modificar = "";
        Statement stmt = null;

        int IdProfesor;
        String Nombre = "";
        String FechaNacimiento = "";
        String Apellido = "";
        int Antiguedad;

        ConsultasProfesor.listadoProfesores(conn);

        System.out.println("Inserte el ID del profesor que quiere modificar");
        IdProfesor = sc.nextInt();
        sc.nextLine();

        Transaccion.empezarTransaccion(conn);

        //Modificación del nombre del Profesor
        System.out.println("¿Quiere modificar el nombre? (Si, No)");
        modificar = sc.nextLine();

        if (modificar.toLowerCase().equals("Si".toLowerCase())) {
            stmt = conn.createStatement();
            System.out.println("¿Cuál es el nuevo nombre?");
            Nombre = sc.nextLine();
            stmt.executeUpdate("UPDATE Profesores SET Nombre = '" + Nombre + "' WHERE idProfesor = " + IdProfesor + ";");
            System.out.println("Editado correctamente");

        }

        //Modificación del apellido del Profesor
        System.out.println("¿Quiere modificar el apellido? (Si, No)");
        modificar = sc.nextLine();

        if (modificar.toLowerCase().equals("Si".toLowerCase())) {
            stmt = conn.createStatement();
            System.out.println("¿Cuál es el nuevo apellido del profesor?");
            Apellido = sc.nextLine();
            stmt.executeUpdate("UPDATE Profesores SET Apellidos = '" + Apellido + "' WHERE idProfesor = " + IdProfesor + ";");
            System.out.println("Editado correctamente");

        }

        //Modificación de la fecha de nacimiento del Profesor
        System.out.println("¿Quiere modificar la Fecha de Nacimiento? (Si, No)");
        modificar = sc.nextLine();

        if (modificar.toLowerCase().equals("Si".toLowerCase())) {
            stmt = conn.createStatement();
            System.out.println("¿Cuál es  la nueva Fecha de Nacimiento del profesor? (ej. 1974-12-11) ");
            FechaNacimiento = sc.nextLine();
            stmt.executeUpdate("UPDATE Profesores SET FechaNacimiento = '" + FechaNacimiento + "' WHERE idProfesor = " + IdProfesor + ";");
            System.out.println("Editado correctamente");

        }
        //Modificación de la antiguedad del Profesor
        System.out.println("¿Quiere modificar la antiguedad? (Si, No)");
        modificar = sc.nextLine();

        if (modificar.toLowerCase().equals("Si".toLowerCase())) {
            stmt = conn.createStatement();
            System.out.println("Cuál es la nueva antiguedad del profesor " + IdProfesor);
            Antiguedad = sc.nextInt();
            sc.nextLine();
            stmt.executeUpdate("UPDATE Profesores SET Antiguedad = '" + Antiguedad + "' WHERE idProfesor = " + IdProfesor + ";");
            System.out.println("Editado correctamente");

        }

        ConsultasProfesor.listadoProfesoresPorId(conn, IdProfesor);

        System.out.println("¿Estas seguro de que quieres modificarlo?(Si, No)");
        modificar=sc.nextLine();

        if(modificar.toLowerCase().equals("Si".toLowerCase())) {
            Transaccion.confirmarTransaccion(conn);
        } else{
            Transaccion.cancelarTransaccion(conn);
        }
    }
}
