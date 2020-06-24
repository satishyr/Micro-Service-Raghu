package in.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCloudJmsConsumerActiveMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudJmsConsumerActiveMqApplication.class, args);
		System.out.println("JMS Executed :"); 
	}

}
