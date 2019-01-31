
public class HiloTac extends Thread{
	
	String nombre;
	Reloj reloj;
	int repeticiones;

	public HiloTac(String nombre, Reloj reloj, int repeticiones) {
		super(nombre);
		this.reloj = reloj;
		this.repeticiones = repeticiones;
	}
	
	public void run() {
		
		for(int i = 0; i < this.repeticiones; i++) {
			reloj.tac(this);
		}
	}
}