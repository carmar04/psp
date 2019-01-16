package ejercicio217;

public class HiloSumador extends Thread{
	Contador contador;
	int repeticiones;
	
	public HiloSumador(String nombre, Contador contador, int repeticiones) {
		super(nombre);
		this.contador = contador;
		this.repeticiones = repeticiones;
	}
	
	public void run() {
		synchronized (contador) {
			for(int i = 0; i < this.repeticiones; i++) {
				contador.incrementa();
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Resultado del " + getName() + " : " + contador.valor());
		}
	}
}
