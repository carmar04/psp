import java.util.*;
import java.io.*;
public class HolaMundo3{
	public static void main (String[]args){
		Scanner teclado = new Scanner(System.in);
		String fichero = "fichero_texto.txt";
		System.out.println("Introduzca un nombre: ");
		BufferedWriter bw = null;
		
		try{
			bw = new BufferedWriter (new FileWriter (new File(fichero)));
			String nombre = teclado.nextLine();
				for(int i = 0;i<20;i++){
					System.out.println("Hola "+nombre);
					bw.write("Hola "+nombre);
					bw.newLine();
				}
		}catch(FileNotFoundException e){
			System.out.println("Fichero no encontrado.");
		}catch(EOFException e){
			System.out.println("Final del fichero.");
		}catch(Exception e){
			System.out.print("Error al escribir en el archivo.");
		}finally{
			try{
				bw.close();
			}catch(Exception e){
				System.out.println("Error al cerrar el fichero.");
			}
		}

	}
}
