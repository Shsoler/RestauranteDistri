package jms;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import objetos.Pedido;

public class CriaProduto {
//DEFAULT_BROKER_URL é localhost
private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
// url padrão : tcp://localhost:61616"


private static String subject = "PEDIDOS"; //nome fila

public void Enviar(Pedido pedido) throws JMSException {
ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
connectionFactory.setTrustAllPackages(true);
Connection connection = connectionFactory.createConnection();
connection.start();
//criar sessão
Session session = connection.createSession(false,
Session.AUTO_ACKNOWLEDGE);
Destination destination = session.createQueue(subject);
// MessageProducer cria as mensagens
MessageProducer producer = session.createProducer(destination);
ObjectMessage pro = session.createObjectMessage();
pro.setObject(pedido);
//TextMessage message = session.createTextMessage("Hello welcome come to vallysoft ActiveMQ!");
producer.send(pro);
System.out.println("Enviado");

connection.close();
}
}
