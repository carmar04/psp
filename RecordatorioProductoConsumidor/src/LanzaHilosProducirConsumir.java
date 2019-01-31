
public class LanzaHilosProducirConsumir {
	public static void main(String [] args) {
		
		Producto producto = new Producto();
		
		HiloProducir hiloProducir = new HiloProducir("HiloProducir", producto, 20);
		HiloConsumir hiloConsumir = new HiloConsumir("HiloConsumir", producto, 8);
		HiloConsumir hiloConsumir2 = new HiloConsumir("HiloConsumir2", producto, 2);
		
		hiloConsumir.setDaemon(true);
		hiloConsumir2.setDaemon(true);
		
		hiloProducir.start();
		hiloConsumir.start();
		hiloConsumir2.start();
		
		try {
			hiloProducir.join();
		} catch (InterruptedException e) {
			System.out.println("Error al esperar al hilo");
			e.printStackTrace();
		}
		System.out.println("Programa finalizado");
		
	}
}
