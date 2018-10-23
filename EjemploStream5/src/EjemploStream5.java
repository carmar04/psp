import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.omg.CORBA.portable.OutputStream;

import java.*;

public class EjemploStream5 {
	public static void main(String[] args) throws IOException {
		
		ProcessBuilder pb1 = new ProcessBuilder("ls", "-la");
		ProcessBuilder pb2 = new ProcessBuilder("tr", "d", "D");

		Process process1 = pb1.start();
		Process process2 = pb2.start();
		
		java.io.OutputStream os2 = process2.getOutputStream();
		//proceso1
		InputStream is = process1.getInputStream();
		InputStream err = process1.getErrorStream();
		
		InputStreamReader isr1 = new InputStreamReader(is);
		InputStreamReader isr2 = new InputStreamReader(err);
		
		BufferedReader br1 = new BufferedReader(isr1);
		BufferedReader br2 = new BufferedReader(isr2);
		
		//proceso2
		InputStream is2 = process2.getInputStream();
		InputStream err2 = process2.getErrorStream();
		
		InputStreamReader isr12 = new InputStreamReader(is2);
		InputStreamReader isr22 = new InputStreamReader(err2);
		
		BufferedReader br12 = new BufferedReader(isr12);
		BufferedReader br22 = new BufferedReader(isr22);
		
		
		java.io.OutputStream os = process1.getOutputStream();

		String line;
		//captura la salida estandar del programa
		System.out.println("Salida estandar del proceso " + Arrays.toString(args) + " :");
		while ((line = br1.readLine()) != null) {
			os2.write(line.getBytes());
			System.out.println("Salida estandar -> " + line);
		}
		
		//captura la salida de error del programa
		System.out.println("Salida de error " + Arrays.toString(args) + " :");
		while ((line = br2.readLine()) != null) {
			System.out.println("Error -> " +  line);
		}
		
		System.out.println("Salida estandar del proceso " + Arrays.toString(args) + " :");
		while ((line = br12.readLine()) != null) {
			System.out.println("Salida estandar -> " + line);
		}
		
		//captura la salida de error del programa
		System.out.println("Salida de error " + Arrays.toString(args) + " :");
		while ((line = br22.readLine()) != null) {
			System.out.println("Error -> " +  line);
		}
	}
}
