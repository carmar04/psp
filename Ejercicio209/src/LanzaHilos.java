
public class LanzaHilos {
	public static void main(String [] args) {
		//Se crean los hilos HiloConParametros
		HiloConParametros hilo1 = new HiloConParametros("Carles", 7 );
		HiloConParametros hilo2 = new HiloConParametros("Pablo",  5 );
		HiloConParametros hilo3 = new HiloConParametros("Jordi", 3 );
		
		System.out.println("Lanzando los hilos...");
		//Lanzamos los hilos
		hilo1.start();
		hilo2.start();
		hilo3.start();
		
		try {
			//El proceso padres esperará a los hilos hijos
			hilo1.join();
			hilo2.join();
			hilo3.join();
		}catch(Exception e) {
			System.out.println("Error al esperar a los hilos secundarios");
		}
		
		System.out.println("Hilos finalizados");
		System.out.println("Fin del programa principal");
	}
}
