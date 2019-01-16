
public class Reloj {
	
	public boolean tic = true;

	public synchronized void tic() {
		
		while(tic == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Tic");
		tic = false;
		notifyAll();
	}
	
	public synchronized void tac() {
		
		while(tic == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Tac");
		tic = true;
		notifyAll();
	}
}
