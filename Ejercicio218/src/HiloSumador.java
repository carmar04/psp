import java.util.concurrent.Semaphore;

public class HiloSumador extends Thread {

	private String nombre;
	private int numero;
	private Contador contador;
	private Semaphore sem;

	public HiloSumador(String nombre, Contador contador, int numero, Semaphore sem) {
		super(nombre);
		this.contador = contador;
		this.numero = numero;
		this.sem = sem;
	}

	public void run() {
		System.out.println("Hilo en ejecución: " + this.getName());

		try {
			sem.acquire();
			for (int i = 0; i < this.numero; i++) {
				Thread.sleep(1);
				contador.incrementa();
			}
			sem.release();
		} catch (InterruptedException e) {
			System.out.println("Error al hacer esperar al hilo");
			e.printStackTrace();
		}

		System.out.println("Resultado del hilo en ejecución: " + this.getName() + " : " + this.contador.mostrarValor());
	}
}
