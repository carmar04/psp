import java.io.*;
import java.util.*;
public class RecordatorioRunProcessBuilder2 {
	public static void main(String[] args) throws IOException, InterruptedException{
		Scanner teclado = new Scanner(System.in);
		
		ProcessBuilder pb = new ProcessBuilder("java","HolaMundo1");
		pb.directory(new File("/home/carmar04/psp/Holamundo1/bin"));
		Process process = pb.start();
		
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String line;
		while((line = br.readLine()) != null) {
			System.out.println("Salida estander del proceso: " + line);
		}
		
		System.out.print("Pulse una tecla para eliminar el proceso: ");
		String respuesta = teclado.next();
		
		if(respuesta.length() > 0 || respuesta.equalsIgnoreCase("")) {
			process.destroy();
			System.err.println("proceso destruido");
		}else {
			System.out.println("proceso no destruido");
		}
	}
}
