import java.io.*;
import java.util.*;
public class RecordatorioStreamProcessbuilder {
	public static void main(String[] args) throws IOException{
		Scanner teclado = new Scanner(System.in);
		
		ProcessBuilder pb = new ProcessBuilder("ls", "-la");
		Process process = pb.start();
		
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String line;
		while((line = br.readLine()) != null) {
			System.out.println("Salida estandar del proceso -> " + line);
		}
		
		InputStream err = process.getErrorStream();
		InputStreamReader isr2 = new InputStreamReader(err);
		BufferedReader br2 = new BufferedReader(isr2);
		
		String line2;
		while((line2 = br2.readLine()) != null) {
			System.out.println("Salida de error del proceso -> " + line2);
		}
	}
}
