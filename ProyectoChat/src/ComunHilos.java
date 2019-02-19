import java.net.Socket;
import java.util.ArrayList;

public class ComunHilos {
	int CONEXIONES;
	int ACTUALES;
	int MAXIMO;
	Socket tabla[] = new Socket[MAXIMO];
	String mensajes;
	int contadorAdministrador = 0; // contador para adiministrador, solo puede haber 1 administrador

	ArrayList<String> IP = new ArrayList<String>(); // ArrayList para guardar las IP de los clientes
	ArrayList<String> Nombres = new ArrayList<String>(); // ArrayList para guardar los nombres de los clientes
	ArrayList<Socket> sockets = new ArrayList(); // ArrayList para guardar los sockets

	public ComunHilos(int maximo, int actuales, int conexiones, Socket[] tabla, ArrayList<String> IP,
			int contadorAdministrador, ArrayList<String> Nombres, ArrayList<Socket> sockets) {
		MAXIMO = maximo;
		ACTUALES = actuales;
		CONEXIONES = conexiones;
		this.tabla = tabla;
		this.IP = IP;
		mensajes = "";
		this.contadorAdministrador = contadorAdministrador;
		this.Nombres = Nombres;
		this.sockets = sockets;

	}

	public ArrayList<Socket> getSockets() {
		return sockets;
	}

	public void setSockets(ArrayList<Socket> sockets) {
		this.sockets = sockets;
	}

	public ArrayList<String> getNombres() {
		return Nombres;
	}

	public void setNombres(ArrayList<String> nombres) {
		Nombres = nombres;
	}

	public int getContadorAdministrador() {
		return contadorAdministrador;
	}

	public void setContadorAdministrador(int contadorAdministrador) {
		this.contadorAdministrador = contadorAdministrador;
	}

	public ArrayList<String> getIP() {
		return IP;
	}

	public void setIP(ArrayList<String> iP) {
		IP = iP;
	}

	public ComunHilos() {
		super();
	}

	public int getMAXIMO() {
		return MAXIMO;
	}

	public void setMAXIMO(int maximo) {
		MAXIMO = maximo;
	}

	public int getCONEXIONES() {
		return CONEXIONES;

	}

	public synchronized void setCONEXIONES(int conexiones) {
		CONEXIONES = conexiones;
	}

	public String getMensajes() {
		return mensajes;
	}

	public synchronized void setMensajes(String mensajes) {
		this.mensajes = mensajes;
	}

	public int getACTUALES() {
		return ACTUALES;
	}

	public synchronized void setACTUALES(int actuales) {
		ACTUALES = actuales;
	}

	public synchronized void addTabla(Socket s, int i) {
		tabla[i] = s;
	}

	public Socket getElementoTabla(int i) {
		return tabla[i];
	}

}