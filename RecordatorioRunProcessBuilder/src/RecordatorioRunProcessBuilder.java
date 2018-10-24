import java.io.*;
import java.util.*;

public class RecordatorioRunProcessBuilder{
	public static void main(String[] args) throws IOException, InterruptedException{
		ProcessBuilder pb = new ProcessBuilder("gedit");
				
		try {
			Process process = pb.start();
			int resultado = process.waitFor();
			System.out.print(resultado);
		}catch(IOException e) {
			System.out.print("Error en el programa");
		}
	}
}
