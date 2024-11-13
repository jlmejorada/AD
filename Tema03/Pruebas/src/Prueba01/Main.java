package Prueba01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args){
        String url = "jdbc:mysql://dns11036.phdns11.es:3306?";
        String usuario = "jmmejorada";
        String password = "12345";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(conn);
    }
}