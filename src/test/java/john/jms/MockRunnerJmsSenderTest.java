package john.jms;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mockrunner.mock.jms.MockQueue;
import com.mockrunner.mock.jms.MockTextMessage;

/**
 * 	This is a mock test class for testing mocked jms
 * 
 *  *sample only*
 *  
 *  by John
 *  
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:jms-config.xml" })
public class MockRunnerJmsSenderTest {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private MockQueue mockQueue;

	@Test
	public void shouldSendMessage()
	{
		jmsTemplate.send(mockQueue, new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {

				TextMessage message = session.createTextMessage();
				message.setText("This is test message from MockRunner");

				return message;
			}

		});

		@SuppressWarnings("unchecked")
		List<MockTextMessage> list = mockQueue.getReceivedMessageList();
		for (MockTextMessage msg : list)
			try {
				System.out.println(this.getClass().getName() + " sent: " + msg.getText());
			} 
			catch (JMSException e) {
				e.printStackTrace();
			}
	}

}