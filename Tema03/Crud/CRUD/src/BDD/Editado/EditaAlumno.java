package BDD.Editado;

import BDD.Consultas.ConsultasAlumnado;
import BDD.Transaccion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EditaAlumno {

    // Funcion que se encarga de editar el alumno
    public static void editarAlumno(Connection conn, Scanner sc) throws ClassNotFoundException, SQLException {
        String modificar="";
        Statement stmt = null;

        int IdAlumno;
        String Nombre="";
        String FechaNacimiento="";
        String Apellido="";

        ConsultasAlumnado.listadoAlumnado(conn);

        System.out.println("Inserte el ID del alumno que quiere modificar");
        IdAlumno = sc.nextInt();
        sc.nextLine();

        Transaccion.empezarTransaccion(conn);

        //Modificación del nombre del Alumno
        System.out.println("¿Quiere modificar el nombre?(Si, No)");
        modificar=sc.nextLine();

        if(modificar.toLowerCase().equals("Si".toLowerCase())) {
            stmt = conn.createStatement();
            System.out.println("¿Cuál es el nuevo nombre del alumno?");
            Nombre=sc.nextLine();
            stmt.executeUpdate("UPDATE Alumnado SET nombre = '"+Nombre+"' WHERE id = "+ IdAlumno +";");
            System.out.println("Editado correctamente");

        }

        //Modificación del apellido del Alumno
        System.out.println("¿Quiere modificar el apellido?(Si, No)");
        modificar=sc.nextLine();

        if(modificar.toLowerCase().equals("Si".toLowerCase())) {
            stmt = conn.createStatement();
            System.out.println("¿Cuál es el nuevo apellido del alumno?");
            Apellido=sc.nextLine();
            stmt.executeUpdate("UPDATE Alumnado SET apellidos = '"+Apellido+"' WHERE id = "+ IdAlumno +";");
            System.out.println("Editado correctamente");

        }

        //Modificación de la fecha de nacimiento del Alumno
        System.out.println("¿Quiere modificar la Fecha de Nacimiento?(Si, No)");
        modificar=sc.nextLine();

        if(modificar.toLowerCase().equals("Si".toLowerCase())) {
            stmt = conn.createStatement();
            System.out.println("¿Cuál es la nueva Fecha de Nacimiento del alumno? (ej. 1974-12-11) ");
            FechaNacimiento=sc.nextLine();
            stmt.executeUpdate("UPDATE Alumnado SET fechanacimiento = '"+FechaNacimiento+"' WHERE id = "+ IdAlumno +";");
            System.out.println("Editado correctamente");

        }

        ConsultasAlumnado.listadoAlumnadoPorId(conn, IdAlumno);

        System.out.println("¿Estas seguro de que quieres modificarlo?(Si, No)");
        modificar=sc.nextLine();

        if(modificar.toLowerCase().equals("Si".toLowerCase())) {
            Transaccion.confirmarTransaccion(conn);
        } else{
            Transaccion.cancelarTransaccion(conn);
        }

    }

}
