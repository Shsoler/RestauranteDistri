package jms;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Date;

public class DataTest {

	public static void main(String[] args) {
		Date data = new Date();
		try {
			Socket cliente = new Socket("127.0.0.1",5555);
			ObjectInputStream doServer = new ObjectInputStream(cliente.getInputStream());
			data = (Date) doServer.readObject();
			cliente.close();
			System.out.println(data.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
