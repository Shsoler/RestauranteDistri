package jms;

import java.util.ArrayList;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import objetos.Pedido;

/**
* @author RudraG
*
*/
public class listaPedido {
private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
private static String fila = "PEDIDOS";

public static ArrayList<Pedido> pedidos = new ArrayList<>();


public static void Listar() throws JMSException {

ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
connectionFactory.setTrustAllPackages(true);
Connection connection = connectionFactory.createConnection();
connection.start();

// Sessão enviar menssagens
Session session = connection.createSession(false,
Session.AUTO_ACKNOWLEDGE);
System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");
// Acha a fila
Destination destino = session.createQueue(fila);

// MessageConsumer recebe a mensagem
MessageConsumer consumer = session.createConsumer(destino);
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