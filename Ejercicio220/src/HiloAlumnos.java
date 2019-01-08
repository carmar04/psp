
public class HiloAlumnos extends Thread {
	Aula aula;

	public HiloAlumnos (Aula aula) {
		this.aula = aula;
	}

	public void run() {
		System.out.println("Alumno " + Thread.currentThread().getName() + " llegó.");
		try {
			Thread.sleep(1000);
			aula.saludarProfesor();
		} catch (InterruptedException e) {
			System.err.println("Thread alumno interrumpido!");
			System.exit(-1);
		}
	}
}
