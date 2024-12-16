package Main;

import BDD.Editado.EditaAlumno;
import BDD.Editado.EditaMatricula;
import BDD.Editado.EditaProfesor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Editar {


    //Eliges que tablas quieres editar campos
    public static void editarTablas(Connection conn, Scanner sc) throws SQLException, ClassNotFoundException {
        String res = "";
        int opc = 0;
        menuEditar();
        System.out.println("Elige una opcion");
        opc = sc.nextInt();
        while (opc != 0) {
            switch (opc) {
                case 1 -> {
                    EditaProfesor.editarProfesor(conn, sc);
                }
                case 2 -> {
                    EditaAlumno.editarAlumno(conn, sc);
                }
                case 3 -> {
                    EditaMatricula.editarMatricula(conn, sc);
                }
                default -> {
                    System.out.println("Opción no valida");
                }
            }
            menuEditar();
            System.out.println("Elige una opcion");
            opc = sc.nextInt();
            sc.nextLine();
        }
    }

    public static void menuEditar() {
        System.out.println("--------------------");
        System.out.println("========Menú========");
        System.out.println("--------------------");
        System.out.println("1. Editar Profesor");
        System.out.println("2. Editar Alumno");
        System.out.println("3. Editar Matricula");
        System.out.println("0. Salir");
        System.out.println("--------------------");
    }

}
