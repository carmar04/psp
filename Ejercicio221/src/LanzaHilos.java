
public class LanzaHilos {

	public static void main(String[] args) {
		Reloj reloj = new Reloj();
		
		HiloTic hiloTic = new HiloTic("HiloTic", reloj, 6);
		HiloTac hiloTac1 = new HiloTac("HiloTac1", reloj, 3);
		HiloTac hiloTac2 = new HiloTac("HiloTac2", reloj, 3);
		
		hiloTic.start();
		hiloTac1.start();
		hiloTac2.start();
	}

}
