
public class Reloj {
	//Es necesario que tenga un primer estado
	public boolean tic = true;
	
	//Metodo para el tic
	public synchronized void tic(Thread thread) {
		//Mientras tic sea falso le hacemos esperar ya que el otro metodo se estará ejecutando
		while(!tic) {
			try {
				//Hacemos esperar este hilo
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//En caso de que tic sea verdadero se ejecuta la parte de fuera del while
		System.out.println("Nombre del hilo: " + thread.getName() + "---> Tic");
		//Cambiamos el valor de tic para que pueda entrar en el otro metodo
		tic = false;
		//Avisamos al otro hilo que esta esperando para que proceda la ejecución
		notifyAll();
	}
	
	public synchronized void tac(Thread thread) {
		while(tic) {
			try {
				wait();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Nombre del hilo: " + thread.getName() + "---> Tac");
		tic = true;
		notifyAll();
	}
}
