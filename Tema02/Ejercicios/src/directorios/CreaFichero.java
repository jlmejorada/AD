package directorios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CreaFichero {

	public static void main(String[] args) {
		String username = System.getProperty("user.name");
		String directorio = "C:\\Users\\" + username + "\\";
		leeDocumento(directorio, username);

	}

	public static void leeDocumento(String directorio, String user) {
		String rutaArchivo = "src/archivo/carpetas.txt";
		String rutaCompleta="";
		String line = "";

		try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {

			while ((line = reader.readLine()) != null) {

				rutaCompleta=directorio + line;
				
				creaDocumento(rutaCompleta, user);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void creaDocumento(String ruta, String user) {
		String rutaCompleta =  ruta + "\\index.html";
		String carpetaPadre = "";
		try {
			   File fichero = new File(rutaCompleta);
			  
			   carpetaPadre=fichero.getParentFile().getName();
			   
			   if (fichero.createNewFile()) 
			      System.out.println("El documento se ha creado correctamente");
			   else
			      System.out.println("No se ha podido crear el documento");
			} catch (Exception e){
			   e.getMessage();
			}
		
		escribeArchivo(rutaCompleta, ruta, carpetaPadre, user);

	}
	
	public static void escribeArchivo(String ruta, String rutaNoCompleta, String carpeta, String user) {
		String doc = "<html>\r\n"
					+ "   <head>\r\n"
					+ "      <title>" + carpeta + "</title>\r\n"
					+ "   </head>\r\n"
					+ "   <body>\r\n"
					+ "      <h1>[" + rutaNoCompleta + "]</h1>\r\n"
					+ "      <h3>Autor:" + user  + "</h3>\r\n"
					+ "   </body>\r\n"
					+ "</html>";
		
        BufferedWriter bw = null;
        
        try {
            bw = new BufferedWriter (new FileWriter (ruta));
            bw.write(doc);
        } catch (IOException e) {
            System.out.println("Ha habido algún error");
        }finally {
            try {
                bw.flush();
                bw.close();
            } catch (IOException e) {
                System.out.println("Ha habido algún error");
            }
        }
        
    }
	
}
