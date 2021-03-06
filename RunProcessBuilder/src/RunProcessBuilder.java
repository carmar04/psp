import java.util.*;
import java.io.*;

public class RunProcessBuilder {

	public static void main(String[] args) throws IOException {
		//Si no introducimos un programa pasado como parametro el proceso no se iniciará
		if (args.length <= 0) { 
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		//Creamos un objeto process builder pasandole al constructor el comando que nos viene como parametro
		ProcessBuilder pb = new ProcessBuilder(args);
		try {
			//Inciamos el proceso
			Process process = pb.start();
			int retorno = process.waitFor();
			//Espera a que el proceso termine
			System.out.println("La ejecución de " + Arrays.toString(args) + " devuelve " + retorno);
			//Devolvemos el programa que ha sido pasado como argumento
		} catch (IOException ex) {
			System.err.println("Excepción de E/S");
			System.exit(-1);
		} catch (InterruptedException ex) {
			System.err.println("El proceso hijo finalizó de forma incorrecta");
		}
	}
}
