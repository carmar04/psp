import java.util.ArrayList;
import java.util.Scanner;

public class LanzaHilos {
	public static void main(String [] args) throws Exception {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Cuantos hilos deseas crear? ");
		int respuesta = teclado.nextInt();
		AcumulaHilos [] lista = new AcumulaHilos [respuesta];
		
		for(int indice = 0; indice <respuesta; indice++) {
			lista[indice] = (new AcumulaHilos(indice));
			lista[indice].start();
		}
	}
}
