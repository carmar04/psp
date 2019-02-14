
import java.io.*;
import java.net.*;
public class HiloServidorChat extends Thread{

	DataInputStream fentrada;
	Socket socket = null;
	ComunHilos comun;
	
	
	public HiloServidorChat(Socket s, ComunHilos comun) {
		this.socket = s;
		this.comun = comun;
		try {
			//CREO FLUJO DE entrada para leer los mensajes 
			fentrada = new DataInputStream(socket.getInputStream());
		}catch(IOException e){
			System.out.println("ERROR DE E/S");
			e.printStackTrace();
		}
	}
	public void run() {
		System.out.println("NÚMERO DE CONEXIONES ACTUALES: "+comun.getACTUALES());
		//NADA MAS CONECTARSE LE ENVIO TODOS LOS MENSAJES
		String texto = comun.getMensajes();
		EnviarMensajeaTodos(texto);
		
		while(true) {
			String cadena = "";
			try {
				cadena=fentrada.readUTF();
				
				if(cadena.trim().contains("192.168.26")) {//CLIENTE DESCONECTA
					for(int i = 0; i<comun.IP.size(); i++) {
						if(cadena.equalsIgnoreCase(comun.IP.get(i))) {
							comun.IP.remove(i);
						}
					}
					System.out.println("Carles eres un becario");
					comun.setACTUALES(comun.getACTUALES()-1);
					System.out.println("NÚMERO DE CONEXIONES ACTUALES: "+comun.getACTUALES());
					break; //sale del bucle
					
				}
				
				comun.setMensajes(comun.getMensajes()+cadena+ "\n");
				EnviarMensajeaTodos(comun.getMensajes());
			}catch(IOException e){
				e.printStackTrace();
				break;
			}
		}//fin while
		
		try {
			socket.close();
		}catch(IOException e){
			e.printStackTrace();
			
		}
	}// run
	
	//ENVIA LOS MENSAJES DEL CHAT A LOS CLIENTES
	private void EnviarMensajeaTodos(String texto) {
		int i;
		for(i= 0; i<comun.getCONEXIONES();i++) {
			Socket s1 = comun.getElementoTabla(i);
			if(!s1.isClosed()) {
				try {
					DataOutputStream fsalida2 = new DataOutputStream(s1.getOutputStream());
					fsalida2.writeUTF(texto);
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}//for
	}//EnviarMensajeaTodos	
}//HiloServidorChat