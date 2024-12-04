import java.sql.*;
import java.util.Scanner;

public class Main {

    static Connection conn = null;
    static Scanner sc = new Scanner(System.in);

    //Main que llama al menú y a las clases
    public static void main(String[] args) throws SQLException {
        int opc = 0;
        Conexion.conectar();
        menu();
        System.out.println("Elige una opcion");
        opc = sc.nextInt();
        while (opc != 0) {
            switch (opc) {
                case 1 -> {
                    crearTablas();
                }
                case 2 -> {

                }
                case 3 -> {

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
        }
        sc.close();
        System.out.println("Saliendo...");
    }

    public static void crearTablas() {
        String res = "";
        int opc = 0;
        menuTablas();
        System.out.println("Elige una opcion");
        opc = sc.nextInt();
        while (opc != 0) {
            switch (opc) {
                case 1 -> {
                    if (CreaciónTablas.creaTablaProfesor() && CreaciónTablas.creaTablaAlumnado() && CreaciónTablas.creaTablaMatricula()) {
                        res = "Tablas creadas correctamente";
                    } else {
                        res = "Las tablas no se han podido crear";
                    }
                    System.out.println(res);
                }
                case 2 -> {
                    if (CreaciónTablas.creaTablaProfesor()) {
                        res = "Tabla creada correctamente";
                    } else {
                        res = "La tabla no se ha podido crear";
                    }
                    System.out.println(res);
                }
                case 3 -> {
                    if (CreaciónTablas.creaTablaAlumnado()) {
                        res = "Tabla creada correctamente";
                    } else {
                        res = "La tabla no se ha podido crear";
                    }
                    System.out.println(res);
                }
                case 4 -> {
                    if (CreaciónTablas.creaTablaMatricula()) {
                        res = "Tabla creada correctamente";
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

//    // Listado ordenado por edad.
//    public static void listadoEdad() throws SQLException {
//        PreparedStatement listaEdad = conn.prepareStatement("SELECT * FROM Persona ORDER BY edad");
//        ResultSet lista=listaEdad.executeQuery();
//        int rowCount=0;
//        while(lista.next()) {
//            rowCount++;
//            System.out.println("ID: " + lista.getInt("id") + " ");
//            System.out.println("Nombre: " + lista.getString("nombre"));
//            System.out.println("Apellido: " + lista.getString("apellido"));
//            System.out.println("Edad: " + lista.getInt("edad"));
//            System.out.println("-----------------------------------------");
//        }
//        lista.close();
//    }





}