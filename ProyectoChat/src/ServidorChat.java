import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.SocketSecurityException;
import java.util.ArrayList;

public class ServidorChat {
	static final int MAXIMO = 10;//MÁXIMO DE CONEXIONES PERMITIDAS
			
			public static void main(String args[]) throws IOException{
		int PUERTO = 44444;
		ServerSocket servidor = new ServerSocket(44444);
		
		System.out.println("Servidor iniciando...");
		
		Socket tabla[] = new Socket[MAXIMO];//control de clientes
		
		String ip;
		boolean carles = true;//Booleano para comprobar si el mismo cliente ha iniciado dos chats
	
		Socket socket;
	
		ArrayList<String> IP = new ArrayList<String>();//Array de IPs
		ArrayList<String> Nombres = new ArrayList<String>();//Array de nombres
		int contadorAdministrador =0;//Contador para que solo haya un administrador
		ArrayList<Socket> sockets = new ArrayList<Socket>();//Array de sockets
		
		ComunHilos comun = new ComunHilos(MAXIMO,0,0,tabla,IP,contadorAdministrador,Nombres,sockets);
		comun.setContadorAdministrador(0);
		while(comun.getCONEXIONES() < MAXIMO) {
			socket = new Socket();
			socket = servidor.accept();

			//Recoge la IP del socket del cliente
            ip = socket.getRemoteSocketAddress().toString();
            //separa la IP del puerto
			String[] parts = ip.split(":");
            String part1 = parts[0]; 
            //Imprime la IP
            System.out.println(part1);
            //Recorre el Array de IPs para comprobar que la IP no esté repetida
			for(int i=0; i<IP.size();i++) {
				if(part1.equalsIgnoreCase(IP.get(i))) {
					carles =false;
					break;
				}
            }
            //si no está repetida
			if(carles == true) {
                //Añade la IP al array de IPs
                IP.add(part1);
                //Añade el socket al array de sockets
				sockets.add(socket);
				comun.addTabla(socket,comun.getCONEXIONES());
				comun.setACTUALES(comun.getACTUALES()+1);
				comun.setCONEXIONES(comun.getCONEXIONES()+1);
				HiloServidorChat hilo = new HiloServidorChat(socket,comun);
				hilo.start();
			}	
		}
		servidor.close();
		
		}//main

}//ServidorChat..
