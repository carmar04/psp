
public class ComienzaClase {
	public static void main(String[] args) {
		// Objeto compartido
		Aula b = new Aula();
		int n_alumnos = 10;
		for (int i = 0; i < n_alumnos; i++) {
			HiloAlumnos alumno = new HiloAlumnos(b);
			alumno.setName("alumno-" + i);
			alumno.start();
		}
		HiloProfesores profesor = new HiloProfesores("Manolo Gómez", b);
		profesor.start();
	}
}
