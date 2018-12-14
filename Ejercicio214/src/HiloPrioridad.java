
public class HiloPrioridad extends Thread{
	//Creamos variables internas al hilo
	//Numero de veces que ha estado el contador en el procesador
	private int c = 0;
	private boolean stophilo = false;
	
	//Constructor de la clase hiloPrioridad1, admite un parametro de cadena de texto
	public HiloPrioridad(String nombre) {
		//Invocas al constructor de la clase superior, a traves del cual, ponemos un nombre debido a que
		//hay un constructor de la clase Thread que si le pasas una cadena de texto le pone ese nombre
		super(nombre);
	}
	//Creamos el metodo getContador que nos devolverá el valor del contador
	public int getContador() {
		return c;
	}
	//Creamos el metodo paraHilo para detener el hilo
	public void pararHilo() {
		stophilo = true;
	}
	//metodo ejecutador cuando se realiza el start() en el main
	public void run() {
		System.out.println("Soy " + getName());
		//imprime el nombre y la prioridad del hilo
		System.out.println("Prioridad " + this.getName() + ": " + this.getPriority());
		//Mientras no esté parado el hilo esperará 2 milisegundos
		while(!stophilo) {
			try {
				Thread.sleep(2);
			}catch(Exception e) {
				e.getMessage();
			}
			//Incrementa la variable interna contador
			c++;
		}
	}
	
}
