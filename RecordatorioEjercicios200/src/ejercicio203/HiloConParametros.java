package ejercicio203;

import java.util.concurrent.Semaphore;

public class HiloConParametros extends Thread {
	
	int repeticiones;
	Semaphore semaphore = new Semaphore(1);
	
	public HiloConParametros(String nombre, int repeticiones) {
		super(nombre);
		this.repeticiones = repeticiones;
	}
	
	public synchronized void sumar() {
		for(int i = 0; i < this.repeticiones; i++) {
			System.out.println("Hilo " + getName() + " iteración: " + i);
		}
	}
	
	public void run() {
		sumar();
		
	}

}
