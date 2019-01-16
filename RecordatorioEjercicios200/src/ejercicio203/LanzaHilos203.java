package ejercicio203;

public class LanzaHilos203 {
	public static void main(String [] args) {
		HiloConParametros hiloConParametros = new HiloConParametros("Jordi", 3);
		HiloConParametros hiloConParametros2 = new HiloConParametros("Carles", 5);
		HiloConParametros hiloConParametros3 = new HiloConParametros("Pablo", 7);
		
		hiloConParametros.start();
		hiloConParametros2.start();
		hiloConParametros3.start();
	}
}
