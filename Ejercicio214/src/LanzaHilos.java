import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class LanzaHilos {
	public static void main(String[] args) {
		HiloPrioridad h1 = new HiloPrioridad("Hilo 1");
		HiloPrioridad h2 = new HiloPrioridad("Hilo 2");
		HiloPrioridad h3 = new HiloPrioridad("Hilo 3");
		
		h1.setPriority(1);
		h2.setPriority(5);
		h3.setPriority(10);
		
		h1.start();
		h2.start();
		h3.start();
	}
}
