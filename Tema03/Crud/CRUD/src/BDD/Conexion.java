package BDD;

import Main.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Conectar con la bdd
    public static Connection conectar() {
        String url = "jdbc:mysql://dns11036.phdns11.es:3306/ad2425_jlmejorada";
        String usuario = "jlmejorada";
        String password = "12345";
        try {
            Main.conn = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Main.conn);
        return Main.conn;
    }
}
