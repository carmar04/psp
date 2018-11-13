import java.lang.reflect.Array;
import java.util.ArrayList;

public class HiloFibonacci extends Thread {
	public int numero = 0;
	public HiloFibonacci(int numero) {
		this.numero = numero;
	}
	public void run() {
		int [] lista = new int[this.numero];
		lista[0] = 0;
		lista[1] = 1;
		int suma = 0;
		System.out.println(lista[0]);
		System.out.println(lista[1]);
		for(int i = 1; i < numero; i++) {
			if(i != lista.length - 1) {
				suma = lista[i] + lista[i - 1];
				lista[i + 1] = suma;
				System.out.println(suma);
			}else {
				System.out.println("Fin del programa.");
			}
		}
	}
}
