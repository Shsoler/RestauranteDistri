import java.util.ArrayList;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import jms.ConsumerListener;
import objetos.Pedido;

/**
* @author RudraG
*
*/
public class Consumer {
private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
private static String subject = "PEDIDOS";

public static ArrayList<Pedido> pedidos;


public static void main(String[] args) throws JMSException {
if(pedidos == null){
	pedidos = new ArrayList<>();
}
ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
connectionFactory.setTrustAllPackages(true);
Connection connection = connectionFactory.createConnection();
connection.start();

// Sessão enviar menssagens
Session session = connection.createSession(false,
Session.AUTO_ACKNOWLEDGE);
System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");
// Acha a fila
Destination destination = session.createQueue(subject);

// MessageConsumer recebe a mensagem
MessageConsumer consumer = session.createConsumer(destination);
//Message message = consumer.receive();

ConsumerListener cl = new ConsumerListener();

consumer.setMessageListener(cl);
//mensagem precisa ser transformada em textmessage
//if (message instanceof ObjectMessage) {
//ObjectMessage textMessage = (ObjectMessage) message;
//Pedido ped = (Pedido) textMessage.getObject();
//System.out.println(ped
//+ "'");


}
}