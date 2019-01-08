
public class HiloProfesores extends Thread {
	String nombre;
	Aula aula;

	public HiloProfesores(String nombre, Aula aula) {
		this.nombre = nombre;
		this.aula = aula;
	}

	public void run() {
		System.out.println(nombre + " llegó.");
		try {
			Thread.sleep(1000);
			aula.llegadaProfesor(nombre);
		} catch (InterruptedException e) {
			System.err.println("Thread profesor interrumpido!");
			System.exit(-1);
		}
	}
}
