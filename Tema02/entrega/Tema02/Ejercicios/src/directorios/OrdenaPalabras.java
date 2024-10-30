package directorios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class OrdenaPalabras {

	public static void main(String[] args) {
        leeDocumento();
    }
	
	public static void leeDocumento() {
        String rutaArchivo = "src/archivo/palabrasSeparadas.txt";
        int cont=0;
        ArrayList<String> palabras = new ArrayList<>();
        String linea;

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {

			while ((linea = reader.readLine()) != null) {				
				palabras.add(linea);
				cont++;

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        Collections.sort(palabras);
        escribeArchivo(palabras);
        
    }
	
	public static void escribeArchivo(ArrayList<String> palabras) {
        String ruta = "src/archivo/palabrasOrdenadas.txt";
        BufferedWriter bw = null;
        try {
            // Abrir el archivo en modo append para no sobrescribir
            bw = new BufferedWriter(new FileWriter(ruta, true));
            for (String palabra: palabras) {
                bw.write(palabra + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ha habido algún error");
        } finally {
            try {
                if (bw != null) {
                    bw.flush();
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println("Ha habido algún error al cerrar el archivo");
            }
        }

    }

}
