package john.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

//import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.stereotype.Service;

/**
 * 	This is a stand alone spring based app used to send message
 * 
 *  *sample only*
 *  
 *  by John
 *  
 *
 */

public class JmsMessageSender {

	public static void main(String arg[]) {

		@SuppressWarnings("resource")
		final ApplicationContext context = new ClassPathXmlApplicationContext("classpath:./spring-config.xml");
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				Message message = session.createTextMessage("standalone sent msg.");

				DefaultMessageListenerContainer listener = context.getBean("listener1",
						DefaultMessageListenerContainer.class);
				//listener.stop();
				//listener.start();

				return message;
			}
		});

	}

}
