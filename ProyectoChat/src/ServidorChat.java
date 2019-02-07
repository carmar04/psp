
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorChat {
	static final int MAXIMO = 10;// MÁXIMO DE CONEXIONES PERMITIDAS

	public static void main(String args[]) throws IOException {
		int PUERTO = 44444;
		ServerSocket servidor = new ServerSocket(PUERTO); // TODO
		System.out.println("Servidor iniciando...");

		Socket tabla[] = new Socket[MAXIMO];// control de clientes
		ComunHilos comun = new ComunHilos(MAXIMO, 0, 0, tabla);
		while (comun.getCONEXIONES() < MAXIMO) {
			Socket socket = new Socket();
			socket = servidor.accept();// esperando cliente
			comun.addTabla(socket, comun.getCONEXIONES());
			comun.setACTUALES(comun.getACTUALES() + 1);
			comun.setCONEXIONES(comun.getCONEXIONES() + 1);
			HiloServidorChat hilo = new HiloServidorChat(socket, comun);
			hilo.start();
		}

		servidor.close();

	}// main

}// S
