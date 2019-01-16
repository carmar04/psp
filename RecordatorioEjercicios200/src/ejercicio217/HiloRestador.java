package ejercicio217;

public class HiloRestador extends Thread{

	Contador contador;
	int repeticiones;
	
	public HiloRestador(String nombre, Contador contador, int repeticiones) {
		super(nombre);
		this.contador = contador;
		this.repeticiones = repeticiones;
	}
	
	public void run() {
		synchronized (contador) {
			for(int i = 0; i < this.repeticiones; i++) {
				contador.decrementa();
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
