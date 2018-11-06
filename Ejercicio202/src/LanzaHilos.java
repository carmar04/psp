
public class LanzaHilos {
	public static void main(String[] args) {
		RunnableClass rc = new RunnableClass();

		Thread hilo1 = new Thread(rc);
		Thread hilo2 = new Thread(rc);
		Thread hilo3 = new Thread(rc);
		
		//sin setName nos muestra solo el numero de hilo
		//hilo1.setName("Hilo1");
		//hilo2.setName("Hilo2");
		//hilo3.setName("Hilo3");
		System.out.println("Soy el hilo principal, lanzando los hilos...");
		hilo1.start();
		hilo2.start();
		hilo3.start();
		System.out.println("Soy el hilo principal, terminando...");
	}
}
