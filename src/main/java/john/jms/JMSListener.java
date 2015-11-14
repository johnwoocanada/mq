package john.jms;

/**
 * 	This is a POJO but powerful used to listen to coming in messages
 * 
 *  *sample only*
 *  
 *  by John
 *  
 *
 */
public class JMSListener {
	/** The application logger */
	private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(JMSListener.class);

	public void echo(String msg) {

		LOG.info("Received message: " + msg);
		System.out.println("Received message: " + msg);

	}
}
