
public class Contador {
	//parametro
	private int numero = 0;
	
	public Contador(int numero) {
		this.numero = numero;
	}
	//metodos para incrementar
	public void incrementa() {
		this.numero = this.numero + 1;
	}
	//metodos para decrementar
	public void decrementa() {
		this.numero = this.numero - 1;
	}
	//metodo para mostrar el valor de la variable compartida
	public int mostrarValor() {
		return this.numero;
	}
}
