
public class HiloRecursivo extends Thread {
	
	public static int numero;
	public static boolean flag = false;
	private static int siguiente;
	
	public HiloRecursivo() {
		if(!flag) {
			this.numero = 10;
			flag = true;
		}else {
			this.numero = siguiente;
		}
	}

	public void run() {
		if(numero > 0) {
			this.setName("Hilo " + numero);
			this.siguiente = numero - 1;
			System.out.println("Soy el "+ getName() + " y voy a llamar al hilo " + (numero + 1));
			HiloRecursivo hilo = new HiloRecursivo();
			hilo.start();
		}else if(numero == 0) {
			this.setName("Hilo " + numero);
			System.out.println("Soy el " + getName());
		}
	}
}
