
class HiloEspera extends Thread {
	
	private int espera;

	public HiloEspera(int espera) {
		this.espera = espera*1000;
	}

	@Override
	public void run() {
		System.out.println("Soy el " + Thread.currentThread().getName() + " empezando.");
		System.out.println("Soy el " + Thread.currentThread().getName() + " y voy a parar "+ espera +" ms");
		try {
			Thread.sleep(espera);
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrumpido.");
			return;
		}
		System.out.println(Thread.currentThread().getName() + " acabado.");
	}
}