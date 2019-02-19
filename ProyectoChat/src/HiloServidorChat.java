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
		
		//boolean conexionActiva = true;
		
		while(true) {
			String cadena = "";
			try {
				cadena=fentrada.readUTF();
                //Esto lo hará simplemente cuando entra un cliente
				if(cadena.contains(" > Entra en el Chat-")) {
                    //Separamos la cadena en 2, "> Entra en el Chat-" y "Nombre (que hemos escrito al entrarr)"
					String[] parts = cadena.split("-");
                    String part1 = parts[1]; 
                    //Añadimos al ArrayList Nombres, el nombre que entra
                    comun.Nombres.add(part1);
					System.out.println("nombre: "+part1);
                    for(int i = 0; i<comun.IP.size(); i++) {
                        System.out.println(comun.IP.get(i).toString());//Imprime las direcciones IP que hay en el momento
                    }
                }
                //Si el administrador escribe remove
				if(cadena.contains("admin") &&cadena.contains("remove")) {
                    //Separamos "remove-" y "nombre (que haya escrito"
					String[] parts = cadena.split("-");
					String part1 = parts[1]; 
					//Si el nombre que ha escrito coincide con algún nombre que esté en el Array de Nombres
					for(int i = 0; i<comun.Nombres.size(); i++) {
						if(comun.Nombres.get(i).equalsIgnoreCase(part1)) {
                            //Elimina la IP y el nombre de ese cliente de los Arrays
							comun.IP.remove(i);
							comun.Nombres.remove(i);
							try {
                                //Cierra el socket
								comun.sockets.get(i).close();
							}catch(Exception e) {
								System.out.println("usuario eliminado");
							}
							//Elimina el socket del Array de socket
							comun.sockets.remove(i);
							comun.setACTUALES(comun.getACTUALES()-1);
							System.out.println("NÚMERO DE CONEXIONES ACTUALES: "+comun.getACTUALES());
							//conexionActiva = false;
							break;
							
							
						}
					}
				}
				//Si la cadena contiene la dirección IP 126.168.26.XXX
				if(cadena.trim().contains("192.168.26")) {//CLIENTE DESCONECTA
                    System.out.println(cadena);
                    //Recorre el Array de IPs
					for(int i = 0; i<comun.IP.size(); i++) {
                        //Si la IP escrita es igual a una IP que se encuentre en el Array de IPs
						if(cadena.equalsIgnoreCase(comun.IP.get(i))) {
                            System.out.println("se elimina: "+ comun.IP.get(i) + "nombre"+ comun.Nombres.get(i));
                            //Elimina de los Arrays nombre e IPs
							comun.IP.remove(i);
							comun.Nombres.remove(i);
							if (comun.Nombres.get(i).equalsIgnoreCase("admin")) {
								comun.setContadorAdministrador(0);
                            }
                            //Cierra el socket y lo elimina del Array de sockets
							comun.sockets.get(i).close();
							comun.sockets.remove(i);
						}
					}
					
					comun.setACTUALES(comun.getACTUALES()-1);
					System.out.println("NÚMERO DE CONEXIONES ACTUALES: "+comun.getACTUALES());
					
					for(int i = 0; i<comun.IP.size(); i++) {System.out.println(comun.IP.get(i).toString());}
					break; //sale del bucle
					
				}
				
				comun.setMensajes(comun.getMensajes()+cadena+ "\n");
				EnviarMensajeaTodos(comun.getMensajes());
			}catch(IOException e){
				System.out.println("Usuario desconectado");
				break;
			}
		}//fin while
		
		
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