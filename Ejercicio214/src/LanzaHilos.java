import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class LanzaHilos {
	public static void main(String[] args) {
		//Crea los hilos con el parametro nombre
		HiloPrioridad h1 = new HiloPrioridad("Hilo 1");
		HiloPrioridad h2 = new HiloPrioridad("Hilo 2");
		HiloPrioridad h3 = new HiloPrioridad("Hilo 3");
		
		//Asignamos la prioridad de los hilos
		h1.setPriority(Thread.MIN_PRIORITY);
		h2.setPriority(Thread.NORM_PRIORITY);
		h3.setPriority(Thread.MAX_PRIORITY);
		
		//Ejecuta los hilos
		h1.start();
		h2.start();
		h3.start();
		
		try {
			System.out.println("Durmiendo hilo principal");
			Thread.sleep(3000);
			System.out.println("Hilo principal terminado");
		}catch(Exception e) {
			e.getMessage();
		}
		//Paramos los hilos invocando el metodo
		h1.pararHilo();
		h1.pararHilo();
		h1.pararHilo();
		
		//Mostramos el valor del contador de cada uno de cada los hilos
		System.out.println(h1.getContador());
		System.out.println(h2.getContador());
		System.out.println(h3.getContador());
		
	}
}
