
public class LanzaHilos {
	public static void main(String args[]) {
		HiloEspera hilo1 = new HiloEspera();
		HiloEspera hilo2 = new HiloEspera();
		hilo1.setName("hilo 1");
		hilo2.setName("hilo 2");
		hilo1.start();
		hilo2.start();
		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrumpido. ");
			return;
		} catch (Exception e) {
			System.out.print("Hilo principal parado.");
		}
		hilo1.interrupt();
		System.out.println("El programa ha finalizado.");
	}
}
