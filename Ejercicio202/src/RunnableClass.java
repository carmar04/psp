
public class RunnableClass implements Runnable{
	public void run() {
		for(int i = 0; i <= 5; i++) {
			//recoge el nombre actual de hilo
			System.out.println("Ejecutando " + Thread.currentThread().getName() + ":" + i);
			
		}
	}
}
