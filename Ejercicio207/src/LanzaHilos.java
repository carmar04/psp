
import java.util.Scanner;

public class LanzaHilos extends Thread{
	public static void main(String args[]) {
		//creamos los hilos con los segundos que esperarán
		HiloEsperaNseg HiloEsperahilo1 = new HiloEsperaNseg(3);
		HiloEsperaNseg HiloEsperahilo2 = new HiloEsperaNseg(5);
		//ponemos el nombre al hilo utilizando setName() de la clase Thread
		HiloEsperahilo1.setName("hilo 1");
		HiloEsperahilo2.setName("hilo 2");
		
		//Inicializamos el los hilos
		HiloEsperahilo1.start();
		HiloEsperahilo2.start();
		//Hacemos que el hilo principal espere 4 sec con el metodo .sleep(segundos)
		try {
			System.out.println("Soy el hilo principal y voy a esperar 4 segundos");
			Thread.currentThread().sleep(4000);
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrumpido. ");
		}
		System.out.println("Soy el hilo principal y he terminado");
		//HiloEsperahilo1.interrupt();
		
		//* se puede hacer que el main tambien herede de Thread, y se puede ejecutar igualmente con normalidad
	}
}
