import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class recibeEnviaDatagram {
	public static void main(String[] args) {
		try {
			//Dirección en la que esperamos el mensaje
			System.out.println("Creando socket datagrama");
			//Establecemos la ip y la dirección que escucha los mensajes
			InetSocketAddress addr = new InetSocketAddress("192.168.26.111", 5555);
			//Si se le pasa parametro al constructor escucha
			DatagramSocket datagramSocket = new DatagramSocket(addr);
			
			System.out.println("Recibiendo mensaje");
			byte[] mensaje = new byte[25];
			DatagramPacket datagrama1 = new DatagramPacket(mensaje, 25);
			datagramSocket.receive(datagrama1);
			
			System.out.println("Mensaje recibido: " + new String(mensaje));
			System.out.println("Enviando mensaje");
			InetAddress addr2 = InetAddress.getByName("192.168.26.149");
			
			DatagramPacket datagrama2 = new DatagramPacket(mensaje, mensaje.length, addr2, 5556);
			datagramSocket.send(datagrama2);
			
			System.out.println("Mensaje enviado");
			System.out.println("Cerrando el socket datagrama");
			
			
			datagramSocket.close();
			System.out.println("Terminado");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}