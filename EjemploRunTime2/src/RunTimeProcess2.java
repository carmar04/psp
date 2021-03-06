import java.io.IOException;
import java.io.*;
import java.util.*;

public class RunTimeProcess2 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		if (args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		System.out.print("Para eliminar el proceso pulse cualuquier tecla y pulse enter.");
		
		Runtime runtime = Runtime.getRuntime();
			try {
				Process process = runtime.exec(args, null,
						new File("/home/carmar04/psp/EjemploRunTime/bin"));
				
				String respuesta = teclado.nextLine();
				if(respuesta.length()>0 || respuesta.equalsIgnoreCase("")) {
					process.destroy();
					System.err.println("Proceso parado");
				}
			} catch (IOException ex) {
				System.err.println("Excepción de E/S");
				System.exit(-1);
			}
		}
	}
