package Main;

import BDD.Borrado.BorraAlumno;
import BDD.Borrado.BorraMatricula;
import BDD.Borrado.BorraProfesor;
import BDD.Editado.EditaAlumno;
import BDD.Editado.EditaMatricula;
import BDD.Editado.EditaProfesor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Borrar {


    //Aqui se elige la tabla sobre la que vas a trabajar
    public static void borraTabla(Connection conn, Scanner sc) throws SQLException, ClassNotFoundException {
        String res = "";
        int opc = 0;
        menuBorrar();
        System.out.println("Elige una opcion");
        opc = sc.nextInt();
        while (opc != 0) {
            switch (opc) {
                case 1 -> {
                    borraMatricula(conn, sc);
                }
                case 2 -> {
                    borraProfesor(conn, sc);
                }
                case 3 -> {
                    borraAlumno(conn, sc);
                }
                default -> {
                    System.out.println("Opción no valida");
                }
            }
            menuBorrar();
            System.out.println("Elige una opcion");
            opc = sc.nextInt();
            sc.nextLine();
        }
    }

    //Que hacer sobre la tabla matricula
    public static void borraMatricula(Connection conn, Scanner sc) throws SQLException, ClassNotFoundException {
        String res = "";
        int opc = 0;
        menuBorrarMatriculas();
        System.out.println("Elige una opcion");
        opc = sc.nextInt();
        while (opc != 0) {
            switch (opc) {
                case 1 -> {
                    BorraMatricula.BorraTodos(conn, sc);
                }
                case 2 -> {
                    BorraMatricula.BorraPorId(conn, sc);
                }
                case 3 -> {
                    BorraMatricula.BorraPorIdProfesor(conn, sc);
                }
                case 4 -> {
                    BorraMatricula.BorraPorIdAlumno(conn, sc);
                }
                case 5 -> {
                    BorraMatricula.BorraPorAsignatura(conn, sc);
                }
                case 6 -> {
                    BorraMatricula.BorraPorCurso(conn, sc);
                }
                default -> {
                    System.out.println("Opción no valida");
                }
            }
            menuBorrarMatriculas();
            System.out.println("Elige una opcion");
            opc = sc.nextInt();
            sc.nextLine();
        }
    }

    //Que hacer sobre la tabla profesor
    public static void borraProfesor(Connection conn, Scanner sc) throws SQLException, ClassNotFoundException {
        String res = "";
        int opc = 0;
        menuBorrarProfesor();
        System.out.println("Elige una opcion");
        opc = sc.nextInt();
        while (opc != 0) {
            switch (opc) {
                case 1 -> {
                    BorraProfesor.BorraTodos(conn,sc);
                }
                case 2 -> {
                    BorraProfesor.BorraPorId(conn,sc);
                }
                case 3 -> {
                    BorraProfesor.BorraPorNombre(conn,sc);
                }
                case 4 -> {
                    BorraProfesor.BorraPorApellidos(conn,sc);
                }
                case 5 -> {
                    BorraProfesor.BorraPorFechaNacimiento(conn,sc);
                }
                case 6 -> {
                    BorraProfesor.BorraPorAntiguedad(conn,sc);
                }
                default -> {
                    System.out.println("Opción no valida");
                }
            }
            menuBorrarProfesor();
            System.out.println("Elige una opcion");
            opc = sc.nextInt();
            sc.nextLine();
        }
    }

    //Que hacer sobre la tabla alumno
    public static void borraAlumno(Connection conn, Scanner sc) throws SQLException, ClassNotFoundException {
        String res = "";
        int opc = 0;
        menuBorrarAlumno();
        System.out.println("Elige una opcion");
        opc = sc.nextInt();
        while (opc != 0) {
            switch (opc) {
                case 1 -> {
                    BorraAlumno.BorraTodos(conn, sc);
                }
                case 2 -> {
                    BorraAlumno.BorraPorId(conn,sc);
                }
                case 3 -> {
                    BorraAlumno.BorraPorNombre(conn,sc);
                }
                case 4 -> {
                    BorraAlumno.BorraPorApellidos(conn,sc);
                }
                case 5 -> {
                    BorraAlumno.BorraPorFechaNacimiento(conn,sc);
                }
                default -> {
                    System.out.println("Opción no valida");
                }
            }
            menuBorrarAlumno();
            System.out.println("Elige una opcion");
            opc = sc.nextInt();
            sc.nextLine();
        }
    }


    public static void menuBorrar() {
        System.out.println("--------------------");
        System.out.println("========Menú========");
        System.out.println("--------------------");
        System.out.println("1. Borrar tabla Matriculas");
        System.out.println("2. Borrar tabla Profesores");
        System.out.println("3. Borrar tabla Alumnado");
        System.out.println("0. Salir");
        System.out.println("--------------------");
    }

    public static void menuBorrarMatriculas() {
        System.out.println("--------------------");
        System.out.println("========Menú========");
        System.out.println("--------------------");
        System.out.println("1. Borrar toda la tabla Matricula");
        System.out.println("2. Borrar por Id Matricula");
        System.out.println("3. Borrar por Id Profesor");
        System.out.println("4. Borrar por Id Alumno");
        System.out.println("5. Borrar por asignatura");
        System.out.println("6. Borrar por curso");
        System.out.println("0. Salir");
        System.out.println("--------------------");
    }

    public static void menuBorrarAlumno() {
        System.out.println("--------------------");
        System.out.println("========Menú========");
        System.out.println("--------------------");
        System.out.println("1. Borrar toda la tabla Alumno");
        System.out.println("2. Borrar por Id");
        System.out.println("3. Borrar por nombre");
        System.out.println("4. Borrar por apellidos");
        System.out.println("5. Borrar por fecha nacimiento");
        System.out.println("0. Salir");
        System.out.println("--------------------");
    }

    public static void menuBorrarProfesor() {
        System.out.println("--------------------");
        System.out.println("========Menú========");
        System.out.println("--------------------");
        System.out.println("1. Borrar toda la tabla Profesor");
        System.out.println("2. Borrar por Id");
        System.out.println("3. Borrar por nombre");
        System.out.println("4. Borrar por apellidos");
        System.out.println("5. Borrar por fecha nacimiento");
        System.out.println("6. Borrar por antiguedad");
        System.out.println("0. Salir");
        System.out.println("--------------------");
    }

}
