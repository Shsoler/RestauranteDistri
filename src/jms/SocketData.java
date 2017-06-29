package jms;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SocketData {
	public static void main(String[] args){
			ServerSocket meuSocket;
			while(true){
			try{
				meuSocket = new ServerSocket(5555);
				Socket cliente = meuSocket.accept();
				System.out.println("Conexão estabelecida");
				ObjectOutputStream paraCliente = new ObjectOutputStream(cliente.getOutputStream());
				Date data = new Date();
				
				paraCliente.writeObject(data);
				meuSocket.close();
			}catch(Exception e){
				e.printStackTrace();
		}
		}
	}
}
