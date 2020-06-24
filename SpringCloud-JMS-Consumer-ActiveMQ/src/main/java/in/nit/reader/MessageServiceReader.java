package in.nit.reader;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class MessageServiceReader {
	
	@JmsListener(destination = "my-queue-abc")
	public void getMessageFromMom(String message) {
		System.out.println("Data From Mom-->"+message);
	}

}
