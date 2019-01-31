import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class EmisorDatagram {
	public static void main(String[] args) {
		try {
			System.out.println("Creando socket datagram");
			//Sino se le pasa parametro envia
			DatagramSocket datagramSocket = new DatagramSocket();
			
			System.out.println("Enviando mensaje");
			String mensaje = "Guarra contestame";
			
			InetAddress addr = InetAddress.getByName("192.168.26.112");
			DatagramPacket datagrama = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, addr, 5555);
			datagramSocket.send(datagrama);
			
			System.out.println("Mensaje enviado");
			
			InetSocketAddress addr2 = new InetSocketAddress("192.168.26.111", 5555);
			//Si se le pasa parametro al constructor escucha
			DatagramSocket datagramSocket2 = new DatagramSocket(addr2);
			
			System.out.println("Recibiendo mensaje");
			byte[] mensaje2 = new byte[25];
			DatagramPacket datagrama1 = new DatagramPacket(mensaje2, 25);
			datagramSocket2.receive(datagrama1);
			
			System.out.println("Mensaje recibido: " + new String(mensaje2));
			System.out.println("Enviando mensaje");
			
			System.out.println("Cerrando el socket datagrama");
			
			//Cerramos el objeto socket
			datagramSocket.close();
			System.out.println("Terminado");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}