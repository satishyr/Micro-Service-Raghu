package in.nit.producer;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer implements CommandLineRunner {

	@Autowired
	private JmsTemplate jt;
	
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Data sending from Producer App-->");
		/*jt.send("my-queue", new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("-SAMPLE-"+new Date());
			}
		});*/
		jt.send("my-queue",(ses)->ses.createTextMessage("-SAMPLE-"+new Date()));
			
		
	}
}
