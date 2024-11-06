package ultimoEj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Parte01 {

	public static void main(String[] args) {
		String rutaLeer = "src/archivo/1letra.txt";
		String rutaEscribir = "src/archivo/5letras.txt";
		byte aux ;
		char letra = '\0';
		int pos=0;
		StringBuffer buffer = null;
		
		RandomAccessFile file;
		try {
			file = new RandomAccessFile(rutaLeer, "r");
			while (file.getFilePointer() != file.length()) {
				file.seek(pos);
				aux = file.readByte();
				letra=(char)aux;
			}
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RandomAccessFile file2;
		try {
			file2 = new RandomAccessFile(rutaEscribir, "rw");
			for (int i=0;i<5; i++){         	  
				file2.seek(pos);
				file2.writeChar(letra);
			   }     
			   file2.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
