
public class HiloConsumir extends Thread {

	Producto producto;
	int repeticiones;
	
	public HiloConsumir(String nombre, Producto producto, int repeticiones) {
		super(nombre);
		this.producto = producto;
		this.repeticiones = repeticiones;
	}
	
	public void run() {
		for(int i = 0; i < repeticiones + 1; i++) {
			producto.consumir();
		}
	}
}
