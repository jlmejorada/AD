package Main;

import java.sql.Connection;
import java.util.Scanner;

public class Listar {

    //Menu para ver que listar
    public static void listaTablas(Connection conn, Scanner sc) {
        String res = "";
        int opc = 0;
        menuLista();
        System.out.println("Elige una opcion");
        opc = sc.nextInt();
        while (opc != 0) {
            switch (opc) {
                case 1 -> {
                    listaTablaProfesores(conn, sc);
                }
                case 2 -> {
                    listaTablaAlumnado(conn, sc);
                }
                case 3 -> {
                    listaTablaMatriculas(conn, sc);
                }
                default -> {
                    System.out.println("Opción no valida");
                }
            }
            menuLista();
            System.out.println("Elige una opcion");
            opc = sc.nextInt();
            sc.nextLine();
        }
    }

    //Menu para ver que quieres listar dentro de profesores
    public static void listaTablaProfesores(Connection conn, Scanner sc){
        String res = "";
        int opc = 0;
        int num = 0;
        String texto = "";
        menuListaProfesores();
        System.out.println("Elige una opcion");
        opc = sc.nextInt();
        sc.nextLine();
        while (opc != 0) {
            switch (opc) {
                case 1 -> {
                    BDD.Consultas.ConsultasProfesor.listadoProfesores(conn);
                }
                case 2 -> {
                    System.out.println("Dime un id de profesor");
                    num = sc.nextInt();
                    BDD.Consultas.ConsultasProfesor.listadoProfesoresPorId(conn, num);
                }
                case 3 -> {
                    System.out.println("Dime un nombre de profesor");
                    texto = sc.nextLine();
                    BDD.Consultas.ConsultasProfesor.listadoProfesoresPorNombre(conn, texto);
                }
                case 4 -> {
                    System.out.println("Dime un apellido de profesor");
                    texto = sc.nextLine();
                    BDD.Consultas.ConsultasProfesor.listadoProfesoresPorApellidos(conn, texto);
                }
                case 5 -> {
                    System.out.println("Dime la fecha de nacimiento de un profesor");
                    texto = sc.nextLine();
                    BDD.Consultas.ConsultasProfesor.listadoProfesoresPorFecha(conn, texto);

                }
                case 6 -> {
                    System.out.println("Dime la antigüedad de un profesor");
                    num = sc.nextInt();
                    BDD.Consultas.ConsultasProfesor.listadoProfesoresPorAntiguedad(conn, num);

                }
                default -> {
                    System.out.println("Opción no valida");
                }
            }
            menuListaProfesores();
            System.out.println("Elige una opcion");
            opc = sc.nextInt();
            sc.nextLine();
        }
    }

    //Menu para ver que quieres listar dentro de alumnos
    public static void listaTablaAlumnado(Connection conn, Scanner sc){
        String res = "";
        int opc = 0;
        int num = 0;
        String texto = "";
        menuListaAlumnado();
        System.out.println("Elige una opcion");
        opc = sc.nextInt();
        sc.nextLine();
        while (opc != 0) {
            switch (opc) {
                case 1 -> {
                    BDD.Consultas.ConsultasAlumnado.listadoAlumnado(conn);
                }
                case 2 -> {
                    System.out.println("Dime un id de alumno");
                    num = sc.nextInt();
                    BDD.Consultas.ConsultasAlumnado.listadoAlumnadoPorId(conn, num);
                }
                case 3 -> {
                    System.out.println("Dime un nombre de alumno");
                    texto = sc.nextLine();
                    BDD.Consultas.ConsultasAlumnado.listadoAlumnadoPorNombre(conn, texto);
                }
                case 4 -> {
                    System.out.println("Dime un apellido de alumno");
                    texto = sc.nextLine();
                    BDD.Consultas.ConsultasAlumnado.listadoAlumnadoPorApellidos(conn, texto);
                }
                case 5 -> {
                    System.out.println("Dime la fecha de nacimiento de un alumno");
                    texto = sc.nextLine();
                    BDD.Consultas.ConsultasAlumnado.listadoAlumnadoPorFecha(conn, texto);

                }
                default -> {
                    System.out.println("Opción no valida");
                }
            }
            menuListaAlumnado();
            System.out.println("Elige una opcion");
            opc = sc.nextInt();
            sc.nextLine();
        }
    }

    //Menu para ver que quieres listar dentro de matriculas
    public static void listaTablaMatriculas(Connection conn, Scanner sc){
        String res = "";
        int opc = 0;
        int num = 0;
        String texto = "";
        menuListaMatricula();
        System.out.println("Elige una opcion");
        opc = sc.nextInt();
        sc.nextLine();
        while (opc != 0) {
            switch (opc) {
                case 1 -> {
                    BDD.Consultas.ConsultasMatriculas.listadoMatriculas(conn);
                }
                case 2 -> {
                    System.out.println("Dime un id de una matricula");
                    num = sc.nextInt();
                    BDD.Consultas.ConsultasMatriculas.listadoMatriculasPorID(conn, num);
                }
                case 3 -> {
                    System.out.println("Dime un id de un alumno");
                    num = sc.nextInt();
                    BDD.Consultas.ConsultasMatriculas.listadoMatriculasPorIDAlumno(conn, num);
                }
                case 4 -> {
                    System.out.println("Dime un id de un profesor");
                    num = sc.nextInt();
                    BDD.Consultas.ConsultasMatriculas.listadoMatriculasPorIDProfesor(conn, num);
                }
                case 5 -> {
                    System.out.println("Dime el nombre de una asignatura");
                    texto = sc.nextLine();
                    BDD.Consultas.ConsultasMatriculas.listadoMatriculasPorAsignatura(conn, texto);
                }
                case 6 -> {
                    System.out.println("Dime un id Curso");
                    num = sc.nextInt();
                    BDD.Consultas.ConsultasMatriculas.listadoMatriculasPorCurso(conn, num);
                }
                default -> {
                    System.out.println("Opción no valida");
                }
            }
            menuListaMatricula();
            System.out.println("Elige una opcion");
            opc = sc.nextInt();
            sc.nextLine();
        }
    }

    public static void menuLista() {
        System.out.println("--------------------");
        System.out.println("========Menú========");
        System.out.println("--------------------");
        System.out.println("1. Lista tabla Profesores");
        System.out.println("2. Lista tabla Alumnado");
        System.out.println("3. Lista tabla Matriculas");
        System.out.println("0. Salir");
        System.out.println("--------------------");
    }

    public static void menuListaProfesores() {
        System.out.println("--------------------");
        System.out.println("========Menú========");
        System.out.println("--------------------");
        System.out.println("1. Todos los Profesores");
        System.out.println("2. Por Id");
        System.out.println("3. Por Nombre");
        System.out.println("4. Por Apellidos");
        System.out.println("5. Por FechaNacimiento");
        System.out.println("6. Por Antiguedad");
        System.out.println("0. Salir");
        System.out.println("--------------------");
    }

    public static void menuListaAlumnado() {
        System.out.println("--------------------");
        System.out.println("========Menú========");
        System.out.println("--------------------");
        System.out.println("1. Todo el Alumnado");
        System.out.println("2. Por Id");
        System.out.println("3. Por Nombre");
        System.out.println("4. Por Apellidos");
        System.out.println("5. Por FechaNacimiento");
        System.out.println("0. Salir");
        System.out.println("--------------------");
    }

    public static void menuListaMatricula() {
        System.out.println("--------------------");
        System.out.println("========Menú========");
        System.out.println("--------------------");
        System.out.println("1. Todas las Matriculas");
        System.out.println("2. Por Id");
        System.out.println("3. Por IdAlumnado");
        System.out.println("4. Por IdProfesor");
        System.out.println("5. Por Asignatura");
        System.out.println("6. Por Curso");
        System.out.println("0. Salir");
        System.out.println("--------------------");
    }
}
