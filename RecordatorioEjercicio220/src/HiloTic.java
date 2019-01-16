
public class HiloTic extends Thread{
	
	Reloj reloj;
	int repeticiones;

	public HiloTic(String nombre, Reloj reloj, int repeticiones) {
		super(nombre);
		this.reloj = reloj;
		this.repeticiones = repeticiones;
	}
	
	public void run() {
		for(int i = 0; i < repeticiones; i++) {
			reloj.tic();
		}
	}
}
