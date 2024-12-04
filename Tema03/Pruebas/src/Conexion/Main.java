package Conexion;

import java.sql.*;
import java.util.Scanner;

public class Main {

    static Connection conn = null;

    //Main que llama al menú y a las clases
    public static void main(String[] args) throws SQLException {
        int opc=0;
        Scanner sc = new Scanner(System.in);
        conectar();
        menu();
        System.out.println("Elige una opcion");
        opc=sc.nextInt();
        while(opc!=0){
            switch(opc){
                case 1 -> {
                    listadoEdad();
                }
                case 2 -> {
                    listadoApellidos();
                }
                case 3 -> {
                    listadoMas30();
                }
                case 4 -> {
                    listadoApellidoPorJ();
                }
                case 5 -> {
                    listadoNombrePorCApellidoPorAYEdad();
                }
                case 6 -> {
                    listadoMediaEdad();
                }
                case 7 -> {
                    listadodeApellidosConLetrasWaOMa();
                }
                case 8 -> {
                    listadoEntre24Y32();
                }
                case 9 -> {
                    listadoMas65();
                }
                case 10 -> {
                    creacionYActualizacion();
                }
                case 11 -> {
                    listadoTotal();
                }
                default -> {
                    System.out.println("Opción no valida");
                }
            }
            menu();
            System.out.println("Elige una opcion");
            opc=sc.nextInt();
        }
        System.out.println("Saliendo...");
    }

    // Conectar
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

    // Listado ordenado por edad.
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
        lista.close();
    }

    // Listado de nombres y apellidos de más de 30 años
    public static void listadoApellidos() throws SQLException {
        PreparedStatement listaApellido = conn.prepareStatement("SELECT * FROM Persona ORDER BY apellido");
        ResultSet lista=listaApellido.executeQuery();
        int rowCount=0;
        while(lista.next()) {
            rowCount++;
            System.out.println("ID: " + lista.getInt("id") + " ");
            System.out.println("Nombre: " + lista.getString("nombre"));
            System.out.println("Apellido: " + lista.getString("apellido"));
            System.out.println("Edad: " + lista.getInt("edad"));
            System.out.println("-----------------------------------------");
        }
        lista.close();
    }

    // Listado de nombres y apellidos de más de 30 años
    public static void listadoMas30() throws SQLException {
        PreparedStatement listaMas30 = conn.prepareStatement("SELECT * FROM Persona WHERE edad >= 30");
        ResultSet lista=listaMas30.executeQuery();
        int rowCount=0;
        while(lista.next()) {
            rowCount++;
            System.out.println("ID: " + lista.getInt("id") + " ");
            System.out.println("Nombre: " + lista.getString("nombre"));
            System.out.println("Apellido: " + lista.getString("apellido"));
            System.out.println("Edad: " + lista.getInt("edad"));
            System.out.println("-----------------------------------------");
        }
        lista.close();
    }

    // Listado de los nombres que comiencen por "J" ordenados por apellido .
    public static void listadoApellidoPorJ() throws SQLException {
        PreparedStatement listaApellidoPorJ = conn.prepareStatement("SELECT * FROM Persona WHERE nombre LIKE 'J%' ORDER BY apellido");
        ResultSet lista=listaApellidoPorJ.executeQuery();
        int rowCount=0;
        while(lista.next()) {
            rowCount++;
            System.out.println("ID: " + lista.getInt("id") + " ");
            System.out.println("Nombre: " + lista.getString("nombre"));
            System.out.println("Apellido: " + lista.getString("apellido"));
            System.out.println("Edad: " + lista.getInt("edad"));
            System.out.println("-----------------------------------------");
        }
        lista.close();
    }

    // Listado de los nombres que comiencen por "C" y los apellidos por "A" ordenados por edad de mayor a menor.
    public static void listadoNombrePorCApellidoPorAYEdad() throws SQLException {
        PreparedStatement listita = conn.prepareStatement("SELECT * FROM Persona WHERE nombre LIKE 'C%' AND apellido LIKE 'A%' ORDER BY edad");
        ResultSet lista=listita.executeQuery();
        int rowCount=0;
        while(lista.next()) {
            rowCount++;
            System.out.println("ID: " + lista.getInt("id") + " ");
            System.out.println("Nombre: " + lista.getString("nombre"));
            System.out.println("Apellido: " + lista.getString("apellido"));
            System.out.println("Edad: " + lista.getInt("edad"));
            System.out.println("-----------------------------------------");
        }
        lista.close();
    }

    // Media de edad de la muestra.
    public static void listadoMediaEdad() throws SQLException {
        PreparedStatement listita = conn.prepareStatement("SELECT AVG(edad) as 'Media' FROM Persona");
        ResultSet lista=listita.executeQuery();
        int rowCount=0;
        while(lista.next()) {
            rowCount++;
            System.out.println("Media: " + lista.getInt("Media") + " ");
        }
        lista.close();
    }

    // Listado de los apellidos que contengan las letras "oh" o las letras "ma" (si el resultado fuera nulo, cambiar las letras)
    public static void listadodeApellidosConLetrasWaOMa() throws SQLException {
        PreparedStatement listita = conn.prepareStatement("SELECT * FROM Persona WHERE apellido LIKE '%wa%' OR apellido LIKE '%ma%'");
        ResultSet lista=listita.executeQuery();
        int rowCount=0;
        while(lista.next()) {
            rowCount++;
            System.out.println("ID: " + lista.getInt("id") + " ");
            System.out.println("Nombre: " + lista.getString("nombre"));
            System.out.println("Apellido: " + lista.getString("apellido"));
            System.out.println("Edad: " + lista.getInt("edad"));
            System.out.println("-----------------------------------------");
        }
        lista.close();
    }

    // Listado de las personas en la franja de edad comprendida entre los 24 y los 32 años.
    public static void listadoEntre24Y32() throws SQLException {
        PreparedStatement listita = conn.prepareStatement("SELECT * FROM Persona WHERE edad >= 24 AND edad <= 32");
        ResultSet lista=listita.executeQuery();
        int rowCount=0;
        while(lista.next()) {
            rowCount++;
            System.out.println("ID: " + lista.getInt("id") + " ");
            System.out.println("Nombre: " + lista.getString("nombre"));
            System.out.println("Apellido: " + lista.getString("apellido"));
            System.out.println("Edad: " + lista.getInt("edad"));
            System.out.println("-----------------------------------------");
        }
        lista.close();
    }

    // Listado de las personas mayores de 65 años.
    public static void listadoMas65() throws SQLException {
        PreparedStatement listita = conn.prepareStatement("SELECT * FROM Persona WHERE edad > 65");
        ResultSet lista=listita.executeQuery();
        int rowCount=0;
        while(lista.next()) {
            rowCount++;
            System.out.println("ID: " + lista.getInt("id") + " ");
            System.out.println("Nombre: " + lista.getString("nombre"));
            System.out.println("Apellido: " + lista.getString("apellido"));
            System.out.println("Edad: " + lista.getInt("edad"));
            System.out.println("-----------------------------------------");
        }
        lista.close();
    }

    // Crea una columna denominada "laboral" que contendrá los siguientes valores: estudiante, ocupado, parado, jubilado.
    // Actualiza la columna laboral con el siguiente criterio:
    // Los menores de 18 son estudiantes
    // Los mayores de 65 son jubilados
    // Los de edad impar, que no pertenezcan a los colectivos anteriores, están parados
    // El resto, ocupados
    public static void creacionYActualizacion() throws SQLException {
        ResultSet lista = null;
        PreparedStatement listaEdad = null;
        PreparedStatement actualizar = null;
        PreparedStatement alterarTabla = null;

        try {
            String alterTableQuery = "ALTER TABLE Persona ADD CONSTRAINT laboralEstricto CHECK (laboral IN ('estudiante', 'ocupado', 'jubilado', 'parado'))";
            alterarTabla = conn.prepareStatement(alterTableQuery);

            alterarTabla.executeUpdate();

            String selectQuery = "SELECT id, edad FROM Persona";
            listaEdad = conn.prepareStatement(selectQuery);
            lista = listaEdad.executeQuery();

            String actualizaQuery = "UPDATE Persona SET laboral = ? WHERE id = ?";
            actualizar = conn.prepareStatement(actualizaQuery);

            while (lista.next()) {
                int id = lista.getInt("id");
                int edad = lista.getInt("edad");
                String laboral = "";

                if (edad < 18) {
                    laboral = "estudiante";
                } else if (edad <= 65) {
                    laboral = "jubilado";
                } else if (edad % 2 != 0) {
                    laboral = "parado";
                } else {
                    laboral = "ocupado";
                }

                actualizar.setString(1, laboral);
                actualizar.setInt(2, id);

                actualizar.executeUpdate();
            }

            System.out.println("Columna 'laboral' rellenada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        } finally {
            try {
                if (lista != null) lista.close();
                if (listaEdad != null) listaEdad.close();
                if (actualizar != null) actualizar.close();
                if (alterarTabla != null) alterarTabla.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }

    // Listado total
    public static void listadoTotal() throws SQLException {
        PreparedStatement listita = conn.prepareStatement("SELECT * FROM Persona");
        ResultSet lista=listita.executeQuery();
        int rowCount=0;
        while(lista.next()) {
            rowCount++;
            System.out.println("ID: " + lista.getInt("id") + " ");
            System.out.println("Nombre: " + lista.getString("nombre"));
            System.out.println("Apellido: " + lista.getString("apellido"));
            System.out.println("Edad: " + lista.getInt("edad"));
            System.out.println("Estado laboral: " + lista.getString("laboral"));
            System.out.println("-----------------------------------------");
        }
        lista.close();
    }

    public static void menu(){
        System.out.println("--------------------");
        System.out.println("========Menú========");
        System.out.println("--------------------");
        System.out.println("1. Listar por Edad");
        System.out.println("2. Listar por Apellidos");
        System.out.println("3. Listar Edad >= 30");
        System.out.println("4. Listar Apellido por J");
        System.out.println("5. Listado Nombre por C y Apellido por A y Edad");
        System.out.println("6. Registro media edad");
        System.out.println("7. Listar Apellidos Con Letras wa O ma");
        System.out.println("8. Listar Edad entre 24 y 32");
        System.out.println("9. Listar Edad > 65");
        System.out.println("10. Creación de columna y actualización");
        System.out.println("11. Listado total");
        System.out.println("0. Salir");
        System.out.println("--------------------");
    }
}
