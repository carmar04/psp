
public class Producto {
	
	int producir = 0;
	int consumir = 0;
	
	boolean contenedor = true;

	public synchronized void producir() {
		while(contenedor) {
				System.out.println("HiloProducir  ----> " + producir);
				producir++;
				notifyAll();
				try {
					//wait();
					wait(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					return;
				}
				break;
			}
		}
	
	public synchronized void consumir() {
		while(consumir >= producir) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
		}
		System.out.println("HiloConsumir ----> " + consumir);
		consumir++;
		notifyAll();
	}
}
