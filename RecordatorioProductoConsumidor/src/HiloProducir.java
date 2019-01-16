
public class HiloProducir extends Thread {

	Producto producto;
	int repeticiones;
	
	public HiloProducir(String nombre, Producto producto, int repeticiones) {
		super(nombre);
		this.producto = producto;
		this.repeticiones = repeticiones;
	}
	
	public void run() {
		for(int i = 0; i < repeticiones + 1; i++) {
			producto.producir();
		}
	}
}
