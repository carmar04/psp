package ejercicio216;

public class Contador {
	
	int numero;

	public Contador(int numero) {
		this.numero = numero;
	}
	
	public synchronized void incrementa() {
		this.numero++;
	}
	
	public synchronized void decrementa() {
		this.numero--;
	}
	
	public void mostrarValor(Thread thread) {
		System.out.println("El resultado de " + thread.getName() + " es: " + numero);
	}
}
