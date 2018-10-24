import java.io.*;
import java.util.*;

public class RecordatorioRunProcessBuilder4 {
	public static void main(String[] args) throws IOException, InterruptedException{
		Scanner teclado = new Scanner(System.in);
		
		if(args.length <= 0) {
			System.err.println("No se ha pasado un programa como parametro.");
			System.exit(-1);
		}
		
		ProcessBuilder pb = new ProcessBuilder(args);
		Process process = pb.start();
		
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		int estado = process.waitFor();
		
		System.out.println("La aplicación devuelve " + process.exitValue() + " estado: " + estado);
	}
}