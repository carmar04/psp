import java.io.*;
import java.util.*;

public class RecordatorioRunProcessBuilder3 {
	public static void main(String[] args) throws IOException{
		Scanner teclado = new Scanner(System.in);
		
		ProcessBuilder pb = new ProcessBuilder("ls","-la");
		Process process = pb.start();
		
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String line;
		while((line = br.readLine()) != null) {
			System.out.println("Salida estandar del proceso: " + line);
		}
		System.out.println();
		System.out.println("Introduzca una caracter para finalizar el proceso.");
		String respuesta = teclado.nextLine();
		if(respuesta.length() > 0 ) {
			process.destroy();
			System.out.println("Proceso eliminado correctamente");
		}
	}
}
