
class HiloPrioridad extends Thread {
	public void run() {
		System.out.println("Soy el " + Thread.currentThread().getName() + " empezando.");
		for (int i = 0; i < 10; i++)
			System.out.println("Soy el " + Thread.currentThread().getName() + " iteración " + i);
		System.out.println("Soy el " + Thread.currentThread().getName() + " acabando.");
	}
}