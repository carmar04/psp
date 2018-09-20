import java.io.*;
import java.util.*;
public class HolaMundo2{
	public static void main (String[]args){
		Scanner teclado = new Scanner(System.in);
		String fichero = "fichero_texto.txt";
		System.out.println("Introduzca un nombre: ");
		BufferedWriter bw = null;
		
		try{
			bw = new BufferedWriter (new FileWriter (new File(fichero)));
			String nombre = teclado.nextLine();
				for(int i = 0;i<20;i++){
				bw.write("Hola "+nombre);
				bw.newLine();
			}
		}catch(Exception e){
			System.out.println("Error en la escritura del fichero.");
		}finally{
			try{
				bw.close();
			}catch(Exception e){
				System.out.print("Error al cerrar el fichero.");
			}
		}
	}
}