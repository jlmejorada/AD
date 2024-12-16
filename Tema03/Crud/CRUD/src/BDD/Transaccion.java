package BDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transaccion {

    public static void empezarTransaccion(Connection conn) {
        PreparedStatement textoQuery = null;
        try {
            textoQuery = conn.prepareStatement("START TRANSACTION;");
            textoQuery.execute(); // Se usa execute para sentencias sin resultados
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (textoQuery != null) {
                try {
                    textoQuery.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void confirmarTransaccion(Connection conn) {
        PreparedStatement textoQuery = null;
        try {
            textoQuery = conn.prepareStatement("COMMIT;");
            textoQuery.execute(); // Se usa execute para sentencias sin resultados
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (textoQuery != null) {
                try {
                    textoQuery.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void cancelarTransaccion(Connection conn) {
        PreparedStatement textoQuery = null;
        try {
            textoQuery = conn.prepareStatement("ROLLBACK;");
            textoQuery.execute(); // Se usa execute para sentencias sin resultados
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (textoQuery != null) {
                try {
                    textoQuery.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
    }

}
