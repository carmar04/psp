
public class HiloEspera extends Thread{
	//para metro necesario para el objeto
	private int espera;
	//constructor de la clase
	public HiloEspera(int espera) {
		//recibe los segundos como parametro y se multiplica por 1000 para obtener los milisegundos
		this.espera = espera * 1000;
	}

	@Override
	public void run() {
		// se puede quitar Thread.currentThread() porque desciende de la propia clase Thread
		System.out.println("Soy el " + Thread.currentThread().getName() + " empezando.");
		System.out.println("Soy el " + getName() + " y voy a parar "+ espera +" ms");
		if(this.isDaemon()) {
			System.out.println("Es un demonio");
		}
		try {
			Thread.sleep(espera);//
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrumpido.");
		}
		System.out.println(Thread.currentThread().getName() + " acabado.");
	}
}
