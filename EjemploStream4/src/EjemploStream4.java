import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EjemploStream4 {
	public static void main(String[] args) throws IOException {
		
		ProcessBuilder pb = new ProcessBuilder("java", "HolaMundo4");
		pb.directory(new File("/home/carmar04/eclipse-workspace/Holamundo4/bin"));

		Process process = pb.start();

		InputStream is = process.getInputStream();
		InputStream err = process.getErrorStream();
		
		InputStreamReader isr1 = new InputStreamReader(is);
		InputStreamReader isr2 = new InputStreamReader(err);
		
		BufferedReader br1 = new BufferedReader(isr1);
		BufferedReader br2 = new BufferedReader(isr2);
		
		java.io.OutputStream os = process.getOutputStream();
		os.write("Jordiet\n".getBytes());
		os.flush();

		String line;
		//captura la salida estandar del programa
		System.out.println("Salida estandar del proceso " + Arrays.toString(args) + " :");
		while ((line = br1.readLine()) != null) {
			System.out.println("Salida estandar -> " + line);
		}
		
		//captura la salida de error del programa
		System.out.println("Salida de error " + Arrays.toString(args) + " :");
		while ((line = br2.readLine()) != null) {
			System.out.println("Error -> " +  line);
		}
	}
}
