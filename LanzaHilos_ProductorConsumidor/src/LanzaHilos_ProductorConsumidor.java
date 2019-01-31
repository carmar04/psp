public class LanzaHilos_ProductorConsumidor {
	public static void main(String[] args) {
		// Creamos el objeto Almacen
		Almacen almacen = new Almacen();

		// Creamos un objeto de tipo productor y otro de tipo consumidor para añadir las
		// iteraciones
		// pasadas por parametro
		Productor p1 = new Productor(almacen, 1, 4);
		Consumidor c1 = new Consumidor(almacen, 1, 4);
		
		c1.setDaemon(true);
		
		p1.start();
		c1.start();

		// Encapsulamos los metodos join() de cada hilo ya que el hilo padre
		// puede lanzar una excepción mientras espera a que sus hilos hijos
		// finalicen
		try {
			// Mediante el el metodo join() forzamos al hilo padre que espere a
			// la finalización de p1 y c1 para poder continuar con su ejecución.
			p1.join();
			c1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("***Fin de LanzaHilos***");

	}
}

class Almacen {
	private int numeroEnAlmacen;
	private boolean numeroAlmacenado = false;

	public synchronized int consume() {
		// Inicamos un bucle infinito que saldrá cuando se cumpla condición
		while (numeroAlmacenado == false) {
			try {
				// hacemos que el hilo espere
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Cambiamos el valor de las variables para que el hiloConsumidor puede
		// ejecutarse
		if (numeroAlmacenado) {
			numeroAlmacenado = false;
			notifyAll();
			return numeroEnAlmacen;
		}
		return -1;
	}

	public synchronized void produce(int valor) {
		// Iniciamos el bucle, el cual siempre entrará y se ejecutara
		while (true) {
			numeroEnAlmacen = valor;
			numeroAlmacenado = true;
			notifyAll();
			try {
				// Hacemos que el hiloProducto espere
				wait(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//salimos del bucle
			break;
		}

	}
}

class Productor extends Thread {
	private Almacen almacen;
	private int id;
	private int iteraciones;

	// modificamos el constructor para que acepte otro entero para las iteraciones
	public Productor(Almacen a, int id, int iteraciones) {
		// Utilizamos el constructor de la superClase para ponerle el nombre
		// al hilo con el id añadido
		super("Productor " + id);
		almacen = a;
		this.iteraciones = iteraciones;

	}

	public void run() {
		// Iteramos según el valor que nos han pasado por parametro
		for (int i = 0; i < this.iteraciones; i++) {
			almacen.produce(i);
			// Implementamos la modificación que se nos pide para utilizar el metodo de
			// getName()
			// de la superclase Thread
			System.out.println(this.getName() + " produce el valor " + i);
			try {
				//sleep(500);
				this.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}
}

class Consumidor extends Thread {
	private Almacen almacen;
	private int id;
	private int iteraciones;

	// Añadimos en el constructor el atributo iteraciones al objeto
	public Consumidor(Almacen a, int n, int iteraciones) {
		almacen = a;
		this.id = n;
		this.iteraciones = iteraciones;
	}

	public void run() {
		int valor = 0;
		// Iteramos hasta el valor que se nos pase por parametro
		for (int i = 0; i < this.iteraciones; i++) {
			valor = almacen.consume();
			System.out.println("Consumidor " + id + " en iteraci�n " + i + " consume el valor " + valor);

		}
	}
}
