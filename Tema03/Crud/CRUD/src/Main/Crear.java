package Main;

import java.sql.Connection;
import java.util.Scanner;

public class Crear {

    //Menu que se mueve por la creacion de las tablas
    public static void crearTablas(Connection conn, Scanner sc){
        String res = "";
        int opc = 0;
        menuTablas();
        System.out.println("Elige una opcion");
        opc = sc.nextInt();
        while (opc != 0) {
            switch (opc) {
                case 1 -> {
                    if (BDD.CreaciónTablas.creaTablaProfesor() && BDD.CreaciónTablas.creaTablaAlumnado() && BDD.CreaciónTablas.creaTablaMatricula()) {
                        res = "Tablas creadas correctamente";
                        BDD.InsertarDatosPorDefecto.insertaInicialTablaProfesores(conn);
                        BDD.InsertarDatosPorDefecto.insertaInicialTablaAlumnado(conn);
                        BDD.InsertarDatosPorDefecto.insertaInicialTablaMatricula(conn);
                    } else {
                        res = "Las tablas no se han podido crear";
                    }
                    System.out.println(res);
                }
                case 2 -> {
                    if (BDD.CreaciónTablas.creaTablaProfesor()) {
                        res = "Tabla creada correctamente";
                        BDD.InsertarDatosPorDefecto.insertaInicialTablaProfesores(conn);
                    } else {
                        res = "La tabla no se ha podido crear";
                    }
                    System.out.println(res);
                }
                case 3 -> {
                    if (BDD.CreaciónTablas.creaTablaAlumnado()) {
                        res = "Tabla creada correctamente";
                        BDD.InsertarDatosPorDefecto.insertaInicialTablaAlumnado(conn);
                    } else {
                        res = "La tabla no se ha podido crear";
                    }
                    System.out.println(res);
                }
                case 4 -> {
                    if (BDD.CreaciónTablas.creaTablaMatricula()) {
                        res = "Tabla creada correctamente";
                        BDD.InsertarDatosPorDefecto.insertaInicialTablaMatricula(conn);
                    } else {
                        res = "La tabla no se ha podido crear";
                    }
                    System.out.println(res);
                }
                default -> {
                    System.out.println("Opción no valida");
                }
            }
            menuTablas();
            System.out.println("Elige una opcion");
            opc = sc.nextInt();
        }
    }

    public static void menuTablas() {
        System.out.println("--------------------");
        System.out.println("========Menú========");
        System.out.println("--------------------");
        System.out.println("1. Crear todas las tablas");
        System.out.println("2. Crea tabla Profesores");
        System.out.println("3. Crea tabla Alumnado");
        System.out.println("4. Crea tabla Matriculas");
        System.out.println("0. Salir");
        System.out.println("--------------------");
    }
}
