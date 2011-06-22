package ac.simons.mocksmtp;

import org.subethamail.smtp.MessageHandlerFactory;
import org.subethamail.smtp.server.SMTPServer;

/**
 * @author Michael J. Simons, 2011-06-22
 */
public class Main {
	public static void main(String[] args) {
		final MessageHandlerFactory messageHandlerFactory = new MessageHandlerImpl();
		SMTPServer smtpServer = new SMTPServer(messageHandlerFactory);
		smtpServer.setPort(25000);
		smtpServer.start();
	}
}