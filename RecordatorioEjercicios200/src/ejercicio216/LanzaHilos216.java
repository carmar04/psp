package ejercicio216;

import java.util.concurrent.Semaphore;

public class LanzaHilos216 {

	public static void main(String[] args) {
		Contador contador = new Contador(100);
		Semaphore semaphore = new Semaphore(1);
		
		System.out.println("Valor inicial de contador: " + contador);
		
		HiloSumador hiloSumador = new HiloSumador("Hilo sumador", contador, 200, semaphore);
		HiloRestador hiloRestador = new HiloRestador("Hilo restador", contador, 200, semaphore);
		//HiloRestador hiloRestador2 = new HiloRestador("Hilo restador", contador, 200);
		
		hiloSumador.start();
		hiloRestador.start();
		//hiloRestador2.start();
		
		try {
			hiloSumador.join();
			hiloRestador.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
}
