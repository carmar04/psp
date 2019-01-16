
public class ComienzaClase {
	public static void main(String[] args) {
		// Objeto compartido
		Aula aula = new Aula();
		int n_alumnos = 10;
		for (int i = 0; i < n_alumnos; i++) {
			HiloAlumnos alumno = new HiloAlumnos(aula);
			alumno.setName("alumno-" + i);
			alumno.start();
		}
		HiloProfesores profesor = new HiloProfesores("Manolo Gómez", aula);
		profesor.start();
	}
}
