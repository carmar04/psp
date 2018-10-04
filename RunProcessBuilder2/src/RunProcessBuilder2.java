import java.util.*;
import java.io.*;

public class RunProcessBuilder2 {

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
			pb.directory(new File("/home/carmar04/psp/RunProcessBuilder/bin"));
			Process process = pb.start(); //se inicia y devuelve un objeto de tipo process
			int retorno = process.waitFor(); //es un metodo que se ejecuta sobre el objeto process y espra a que el programa acabe
			//Espera a que el proceso termine
			System.out.println("La ejecución de " + Arrays.toString(args) + " devuelve " + retorno);
			//Devolvemos el programa que ha sido pasado como argumento
		} catch (IOException ex) {
			System.err.println("Excepción de E/S");
			System.exit(-1); //le indica al SO como ha terminado el programa
		} catch (InterruptedException ex) {
			System.err.println("El proceso hijo finalizó de forma incorrecta");
		}
	}
}