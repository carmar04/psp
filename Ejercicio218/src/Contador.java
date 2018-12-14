
public class Contador {
	
	private int numero = 0;
	
	public Contador(int numero) {
		this.numero = numero;
	}
	public void incrementa() {
		this.numero = this.numero + 1;
	}
	public void decrementa() {
		this.numero = this.numero - 1;
	}
	public int mostrarValor() {
		return this.numero;
	}
}
