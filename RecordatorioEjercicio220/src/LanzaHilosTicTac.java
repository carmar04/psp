
public class LanzaHilosTicTac {
	public static void main (String [] args) {
		Reloj reloj = new Reloj();
		
		HiloTic hiloTic = new HiloTic("HiloTic", reloj, 6);
		HiloTac hiloTac = new HiloTac("HiloTac", reloj, 6);
		
		hiloTic.start();
		hiloTac.start();
		
	}
}
