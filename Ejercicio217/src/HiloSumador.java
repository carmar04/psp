
public class HiloSumador extends Thread {

	private String nombre;
	private int numero;
	private Contador contador;
	public HiloSumador(String nombre, Contador contador, int numero) {
		super(nombre);
		this.contador = contador;
		this.numero = numero;
	}
	public void run() {
		System.out.println("Hilo en ejecución: " + this.getName());
		for(int i = 0;i < this.numero;i++) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				System.out.println("Error al hacer esperar al hilo");
				e.printStackTrace();
			}
			contador.incrementa();
		}
		System.out.println("Resultado del hilo en ejecución: " + this.getName() + " : " + this.contador.mostrarValor());
	}
}
