package ejercicio217;

public class Contador {
	int contador;
	
	public Contador(int contador) {
		this.contador = contador;
	}
	
	public void incrementa() {
		this.contador++;
	}
	
	public void decrementa() {
		this.contador--;
	}
	
	public void mostrarValor() {
		System.out.println("Resultado: " + contador);
	}
	
	public int valor() {
		return contador;
	}
}
