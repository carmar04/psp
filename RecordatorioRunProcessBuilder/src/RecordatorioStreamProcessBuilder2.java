import java.io.*;
import java.util.*;

public class RecordatorioStreamProcessBuilder2 {
	public static void main(String[] args) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("passwd");
		Process process = pb.start();
		
		InputStream is = process.getInputStream();
		InputStreamReader isr1 = new InputStreamReader(is);
		BufferedReader br1 = new BufferedReader(isr1);
		
		InputStream err = process.getErrorStream();
		InputStreamReader isr2 = new InputStreamReader(err);
		BufferedReader br2 = new BufferedReader(isr2);
		
		
		OutputStream os = process.getOutputStream();
		os.write("Pablo \n".getBytes());
		os.flush();
		os.write("Pablo \n".getBytes());
		os.flush();
		os.write("Pablo \n".getBytes());
		os.flush();
		
		String line = "";
		while((line = br1.readLine()) != null) {
			System.out.println("Salida estandar del proceso -> " + line);
		}
		
		String line2;
		while((line2 = br2.readLine()) != null) {
			System.out.println("Salida de error del proceso -> " + line2);
		}
		
		
		
	}
}
