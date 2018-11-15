
public class AcumulaHilos extends Thread{
	
	public int numero;
	
	public AcumulaHilos(int numero) throws Exception {
		this.numero = numero;
	}
	public void run() {
		System.out.println("Hilo lanzado " + (numero + 1));
		System.out.println("Hilo finalizado " + (numero + 1));
		
	}
}
