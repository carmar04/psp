
public class HiloConParametros extends Thread {
	//Creamos una clase que hereda de Thread y cremos una variable de la clase
	public String parametro;
	public int repeticion;
	//Constructor con parametros donde recoge el nombre y las iteraciones
	public HiloConParametros(String parametro, int repeticion) {
		//Se llama al constructor de la superclase Thread pasando nombre como parámetro
		super(parametro);
		//this.setName(parametro);
		//Y al constructor de la subclase el numero de repeticiones
		this.repeticion = repeticion;
	}
	public void run() {
		for(int i = 1; i <= this.repeticion; i++) {
			//También podría ser posible poner simplemente getName()
			System.out.println(" Nombre del hilo: " +Thread.currentThread().getName()+ " ->  iteración: " + i);
		}
	}
}
