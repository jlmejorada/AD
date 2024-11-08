package ultimoEj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;

public class Parte03 {

	//Este ejercicio no funciona
	
	public static void main(String[] args) {
		String rutaLeer = "src/archivo/abcde.txt";
		String rutaEscribir = "src/archivo/edcba.txt";
		byte aux ;
		char letra = '\0';
		int posIni=0;
		int posFin=5;
		String letras="";
		StringBuffer buffer = null;
		
		RandomAccessFile file;
		try {
			file = new RandomAccessFile(rutaLeer, "r");
			while(file.getFilePointer() != file.length()) {
	              file.seek(posIni);
	              aux = file.readByte();
	              //letras += ;
	              
	              posIni++;
	          }
	          
	          file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		letras=letras.replace("\n", "");
		letras=letras.replace("\r", "");
		
		RandomAccessFile file2;
		try {
			file2 = new RandomAccessFile(rutaEscribir, "rw");
			for (int i = 0; i < posFin-1; i++) {
                letra = letras.charAt(posFin-i-1);
                file2.writeChar(letra);
                file2.writeChar('\n');
            }   
			file2.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
		
