package BDD;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertarDatosPorDefecto {

    public static void insertaInicialTablaProfesores(Connection conn) {
        BufferedReader br = null;
        String linea =  "";
        String insert = "";
        int filasAfectadas = 0;

        try {
            br = new BufferedReader (new FileReader("insertPorDefecto/Profesores.txt"));
            linea = br.readLine();
            while(linea!=null) {
                insert =  linea ;

                Statement insertUsuario = conn.createStatement();
                insertUsuario.executeUpdate(insert);

                filasAfectadas++;

                linea = br.readLine();
            }

            System.out.println("Filas afectadas: " + filasAfectadas);
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo");
        } catch (IOException e) {
            System.out.println("Ocurrió algún error");
        } catch (SQLException e) {
            System.out.println("Fallo en la insercion");
        }
    }

    public static void insertaInicialTablaAlumnado(Connection conn) {
        BufferedReader br = null;
        String linea =  "";
        String insert = "";
        int filasAfectadas = 0;

        try {
            br = new BufferedReader (new FileReader("insertPorDefecto/Alumnado.txt"));
            linea = br.readLine();
            while(linea!=null) {
                insert =  linea ;

                Statement insertUsuario = conn.createStatement();
                insertUsuario.executeUpdate(insert);

                filasAfectadas++;

                linea = br.readLine();
            }

            System.out.println("Filas afectadas: " + filasAfectadas);
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo");
        } catch (IOException e) {
            System.out.println("Ocurrió algún error");
        } catch (SQLException e) {
            System.out.println("Fallo en la insercion");
        }
    }

    public static void insertaInicialTablaMatricula(Connection conn) {
        BufferedReader br = null;
        String linea =  "";
        String insert = "";
        int filasAfectadas = 0;

        try {
            br = new BufferedReader (new FileReader("insertPorDefecto/Matriculas.txt"));
            linea = br.readLine();
            while(linea!=null) {
                insert =  linea ;

                Statement insertUsuario = conn.createStatement();
                insertUsuario.executeUpdate(insert);

                filasAfectadas++;

                linea = br.readLine();
            }

            System.out.println("Filas afectadas: " + filasAfectadas);
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo");
        } catch (IOException e) {
            System.out.println("Ocurrió algún error");
        } catch (SQLException e) {
            System.out.println("Fallo en la insercion");
        }
    }

}
