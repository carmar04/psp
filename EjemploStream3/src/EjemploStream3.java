import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.io.*;

import org.omg.CORBA.portable.OutputStream;

public class EjemploStream3 {
	public static void main(String[] args) throws IOException {
		
		//ponemos el argumento al processBuilder
		ProcessBuilder pb = new ProcessBuilder("passwd");
		
		//empieza el proceso, no ponemos try/catch porque gestionamos la Excepcion en el main
		Process process = pb.start();
		
		//conectamos un OutputStream a la entrada estandar del hijo para poder escribir en ella
		java.io.OutputStream os = process.getOutputStream();
		
		//introducimos el valor a escribir en el terminal gracias  al OutputStream
		//es necesario el caracter "\n" para que nos muestre todas la lineas
		//vaciamos el OutputStream con flush
		//ponemos el metodo .getBytes porque el metodo "os.write" necesita que se le pasen bytes, no strings, como parametro
		//getbytes transforma una cadena de caracteres en bytes
		os.write("Antonio\n".getBytes());
		os.flush();
		os.write("Antonio\n".getBytes());
		os.flush();
		os.write("Antonio\n".getBytes());
		os.flush();

		//Con InputStream obtenemos la salida estandar del proceso ejecutado
		//y se lo asignamos a un InputStreamReader del que leeremos la salida estandar del
		InputStream is = process.getInputStream();
		InputStreamReader isr1 = new InputStreamReader(is);
		BufferedReader br1 = new BufferedReader(isr1);
		
		//Con getErrorStream obtenemos las salida de error del proceso ejecutado
		//y se lo asignamos a un objeto InputStream del que vamos a poder leer el resultado de dicho error
		InputStream err = process.getErrorStream();
		InputStreamReader isr2 = new InputStreamReader(err);
		BufferedReader br2 = new BufferedReader(isr2);
		
		//se crea una variable que leera los BufferedReader de ambos: salida estandar y error
		String line;

		//Con getErrorStream obtenemos las salida estandar del proceso ejecutado
		//y se lo asignamos a un objeto InputStream del que vamos a poder leer el resultado de dicha salida estandar
		System.out.println("Salida estandar del proceso " + Arrays.toString(args) + " :");
		while ((line = br1.readLine()) != null) {
			System.out.println("Salida estandar ->" + line);
		}

		//Escribimos en la salida estandar del proceso principal
		System.out.println("Salida de error " + Arrays.toString(args) + " :");
		//Leemos las lineas del proceso estandar de error porque esta asociado ese BufferedReader al getStreamReader
		while ((line = br2.readLine()) != null) {
			System.out.println("Error -> " +  line);
		}
	}
}
