package jms;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import objetos.Pedido;
import tela.Pedidos;

public class ConsumerListener implements MessageListener{

	
	@Override
	public void onMessage(Message message) {
		try {
			//mensagem precisa ser transformada em textmessage
			if (message instanceof ObjectMessage) {
				ObjectMessage objMessage = (ObjectMessage) message;
				Pedido ped = (Pedido) objMessage.getObject();
				System.out.println(ped + "'");
				listaPedido.pedidos.add(ped);
				Pedidos.popularTabela();
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
