package Main;

import BDD.Insercciones.InsertaAlumno;
import BDD.Insercciones.InsertaMatricula;
import BDD.Insercciones.InsertaProfesor;

import java.sql.Connection;
import java.util.Scanner;

public class Insertar {


    //eliges a que tabla quieres insertar un miembro
    public static void insertaTablas(Connection conn , Scanner sc) {
        String res = "";
        int opc = 0;
        menuInsertar();
        System.out.println("Elige una opcion");
        opc = sc.nextInt();
        while (opc != 0) {
            switch (opc) {
                case 1 -> {
                    InsertaProfesor.insertarProfesor(conn, sc);
                }
                case 2 -> {
                    InsertaAlumno.insertarAlumno(conn, sc);
                }
                case 3 -> {
                    InsertaMatricula.insertarMatricula(conn, sc);
                }
                default -> {
                    System.out.println("Opción no valida");
                }
            }
            menuInsertar();
            System.out.println("Elige una opcion");
            opc = sc.nextInt();
            sc.nextLine();
        }
    }

    public static void menuInsertar() {
        System.out.println("--------------------");
        System.out.println("========Menú========");
        System.out.println("--------------------");
        System.out.println("1. Inserta Profesor");
        System.out.println("2. Inserta Alumno");
        System.out.println("3. Inserta Matricula");
        System.out.println("0. Salir");
        System.out.println("--------------------");
    }



}
