package Conexion;

import java.sql.*;
import java.util.Scanner;

public class Main {

    static Connection conn = null;

    public static void main(String[] args) throws SQLException {
        int opc=0;
        Scanner sc = new Scanner(System.in);
        conectar();
        menu();
        System.out.println("Elige una opcion");
        opc=sc.nextInt();
        switch(opc){
            case 1 :
                listadoEdad();
            default:
                System.out.println("Opción no valida");
        }
    }

    public static void conectar(){
        String url = "jdbc:mysql://dns11036.phdns11.es:3306/ad2425_jlmejorada";
        String usuario = "jlmejorada";
        String password = "12345";
        try {
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(conn);
    }

    public static void listadoEdad() throws SQLException {
        PreparedStatement listaEdad = conn.prepareStatement("SELECT * FROM Persona ORDER BY edad");
        ResultSet lista=listaEdad.executeQuery();
        int rowCount=0;
        while(lista.next()) {
            rowCount++;
            System.out.println("ID: " + lista.getInt("id") + " ");
            System.out.println("Nombre: " + lista.getString("nombre"));
            System.out.println("Apellido: " + lista.getString("apellido"));
            System.out.println("Edad: " + lista.getInt("edad"));
            System.out.println("-----------------------------------------");
        }
    }

    public static void menu(){
        System.out.println("--------------------");
        System.out.println("========Menú========");
        System.out.println("--------------------");
        System.out.println("1. Listar por Edad");
        System.out.println("--------------------");
    }
}
