package directorios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CreaDirectorio {

	public static void main(String[] args) {
		String username = System.getProperty("user.name");
		String directorio = "C:\\Users\\" + username + "\\";

		leeDocumento(directorio);

	}

	public static void leeDocumento(String directorio) {
		String rutaArchivo = "src/archivo/carpetas.txt";
		String line = "";

		try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {

			while ((line = reader.readLine()) != null) {

				if (creaDirectorio(directorio, line)) {
					System.out.println("Directorio " + directorio + line + " creado correctamente");
				} else {
					System.out.println("La carpeta ya existe");
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean creaDirectorio(String directorio, String linea) {

		return new File(directorio + linea).mkdir();

	}

}
