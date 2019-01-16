
public class LanzaHilosProducirConsumir {
	public static void main(String [] args) {
		
		Producto producto = new Producto();
		
		HiloProducir hiloProducir = new HiloProducir("HiloProducir", producto, 12);
		HiloConsumir hiloConsumir = new HiloConsumir("HiloConsumir", producto, 8);
		
		hiloConsumir.setDaemon(true);
		
		hiloProducir.start();
		hiloConsumir.start();
		
		try {
			hiloProducir.join();
		} catch (InterruptedException e) {
			System.out.println("Error al esperar al hilo");
			e.printStackTrace();
		}
		System.out.println("Programa finalizado");
		
	}
}
