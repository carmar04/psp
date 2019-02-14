
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorChat {
	static final int MAXIMO = 10;// MÁXIMO DE CONEXIONES PERMITIDAS

	public static void main(String args[]) throws IOException {
		int PUERTO = 44444;
		ServerSocket servidor = new ServerSocket(PUERTO); // TODO
		System.out.println("Servidor iniciando...");

		Socket tabla[] = new Socket[MAXIMO];// control de clientes

		String ip;
		boolean carles = true;
		// boleano
		Socket socket;
		ArrayList<String> IP = new ArrayList<String>();
		int contadorAdministrador = 0;
		// ArrayList<Socket> sockets = new ArrayList<Socket>();

		ComunHilos comun = new ComunHilos(MAXIMO, 0, 0, tabla, IP, contadorAdministrador);
		while (comun.getCONEXIONES() < MAXIMO) {
			socket = new Socket();
			socket = servidor.accept();// esperando cliente
			ip = socket.getRemoteSocketAddress().toString();
			String[] parts = ip.split(":");
			String part1 = parts[0];
			System.out.println(part1);
			for (int i = 0; i < IP.size(); i++) {
				if (part1.equalsIgnoreCase(IP.get(i))) {
					carles = false;
					break;
				}
			}
			if (carles == true) {
				IP.add(part1);
				comun.addTabla(socket, comun.getCONEXIONES());
				comun.setACTUALES(comun.getACTUALES() + 1);
				comun.setCONEXIONES(comun.getCONEXIONES() + 1);
				HiloServidorChat hilo = new HiloServidorChat(socket, comun);
				hilo.start();
			}
		}
		servidor.close();

	}// main

}// ServidorChat..
