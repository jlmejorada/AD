package Main;

import BDD.DropTabla;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Drop {

    //Aqui se elige la tabla sobre la que vas a trabajar
    public static void dropTabla(Connection conn, Scanner sc) throws SQLException, ClassNotFoundException {
        String res = "";
        int opc = 0;
        menuDrop();
        System.out.println("Elige una opcion");
        opc = sc.nextInt();
        while (opc != 0) {
            switch (opc) {
                case 1 -> {
                    DropTabla.DropTodos(conn, sc);
                }
                case 2 -> {
                    DropTabla.DropMatricula(conn, sc);
                }
                case 3 -> {
                    DropTabla.DropProfesor(conn, sc);
                }
                case 4 -> {
                    DropTabla.DropAlumnado(conn, sc);
                }
                default -> {
                    System.out.println("Opción no valida");
                }
            }
            menuDrop();
            System.out.println("Elige una opcion");
            opc = sc.nextInt();
            sc.nextLine();
        }
    }

    public static void menuDrop() {
        System.out.println("--------------------");
        System.out.println("========Menú========");
        System.out.println("--------------------");
        System.out.println("1. Drop todas las tablas");
        System.out.println("2. Drop tabla Matriculas");
        System.out.println("3. Drop tabla Profesores");
        System.out.println("4. Drop tabla Alumnado");
        System.out.println("0. Salir");
        System.out.println("--------------------");
    }
}
