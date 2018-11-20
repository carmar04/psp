public class LanzaHilos {
	public static void main(String [] args) throws Exception {
		HiloEspera hiloEspera = new HiloEspera();
		hiloEspera.setName("hilo 1");
		hiloEspera.start();
		
	}
}