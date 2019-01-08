
public class Aula {
	boolean clase_comenzada;

	public Aula() {
		this.clase_comenzada = false;
	}

	// Hasta que el profesor no salude no empieza la clase,
	// por lo que los alumnos esperan con un wait
	public synchronized void saludarProfesor() {
		try {
			while (clase_comenzada == false) {
				wait();
			}
			System.out.println(Thread.currentThread().getName() + " Buenos dias, profesor.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Cuando el profesor saluda avisa a los alumnos con notifyAll de su llegada
	public synchronized void llegadaProfesor(String nombre) {
		System.out.println("Buenos días a todos. Soy el profesor " + nombre);
		this.clase_comenzada = true;
		notifyAll();
	}
}
