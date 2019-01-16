package ejercicio217;

public class LanzaHilos2017 {

	public static void main(String[] args) {
		
		Contador contador = new Contador(100);
		
		System.out.println("Valor inicial de contador: " + contador.valor());
		
		HiloSumador hiloSumador = new HiloSumador("HiloSumador", contador, 300);
		HiloRestador hiloRestador = new HiloRestador("HiloRestador", contador, 300);
		
		hiloSumador.start();
		hiloRestador.start();
		
		try {
			hiloSumador.join();
			hiloRestador.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contador.mostrarValor();
		System.out.println("Programa finalizado");

	}

}
