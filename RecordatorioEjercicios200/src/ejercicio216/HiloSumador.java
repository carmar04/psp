package ejercicio216;

import java.util.concurrent.Semaphore;

public class HiloSumador extends Thread{
	Contador contador;
	String nombre;
	int repeticiones;
	Semaphore semaphore;
	
	public HiloSumador(String nombre, Contador contador, int repeticiones, Semaphore semaphore) {
		super(nombre);
		this.contador = contador;
		this.repeticiones = repeticiones;
		this.semaphore = semaphore;
	}
	
	public void run() {
		try {
			semaphore.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i = 0; i < this.repeticiones; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			contador.incrementa();
			
		}
		contador.mostrarValor(this);
		semaphore.release();
	}
}
