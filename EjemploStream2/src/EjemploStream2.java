import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class EjemploStream2 {
	public static void main(String[] args) throws IOException {

		ProcessBuilder pb = new ProcessBuilder("ls", "-z");

		Process process = pb.start();

		InputStream is = process.getInputStream();
		InputStream err = process.getErrorStream();
		
		InputStreamReader isr1 = new InputStreamReader(err);
		InputStreamReader isr2 = new InputStreamReader(is);
		
		BufferedReader br1 = new BufferedReader(isr1);
		BufferedReader br2 = new BufferedReader(isr2);

		String line;
		System.out.println("Salida del proceso " + Arrays.toString(args) + " :");
		while ((line = br1.readLine()) != null) {
			System.out.println(line);
		}
		
		System.out.println("Salida del proceso " + Arrays.toString(args) + " :");
		while ((line = br2.readLine()) != null) {
			System.out.println(line);
		}
	}
}
