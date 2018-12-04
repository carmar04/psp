
public class LanzaHilosRecursivo {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("--> Iniciando hilo hijo " + Thread.currentThread().getName());
		new HiloRecursivo().start();
	}
}
