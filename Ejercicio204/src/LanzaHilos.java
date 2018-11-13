
public class LanzaHilos {

	public static void main(String[] args) {
		HiloFibonacci hilo = new HiloFibonacci(20);
		
		hilo.start();

	}

}
