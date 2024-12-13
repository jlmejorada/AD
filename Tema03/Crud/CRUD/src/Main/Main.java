package Main;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Connection conn = null;

    static Scanner sc = new Scanner(System.in);;

    public static void main(String[] args) throws SQLException {
        int opc = 0;
        Connection conn = BDD.Conexion.conectar();
        menu();
        System.out.println("Elige una opcion");
        opc = sc.nextInt();
        while (opc != 0) {
            switch (opc) {
                case 1 -> {
                    Crear.crearTablas(conn);
                }
                case 2 -> {

                }
                case 3 -> {
                    Listar.listaTablas(conn);
                }
                case 4 -> {

                }
                case 5 -> {

                }
                default -> {
                    System.out.println("Opción no valida");
                }
            }
            menu();
            System.out.println("Elige una opcion");
            opc = sc.nextInt();
            sc.nextLine();
        }
        sc.close();
        System.out.println("Saliendo...");
    }

    public static void menu() {
        System.out.println("--------------------");
        System.out.println("========Menú========");
        System.out.println("--------------------");
        System.out.println("1. Crear tablas");
        System.out.println("2. Insertar");
        System.out.println("3. Listar");
        System.out.println("4. Modificar");
        System.out.println("5. Borrar");
        System.out.println("0. Salir");
        System.out.println("--------------------");
    }
}