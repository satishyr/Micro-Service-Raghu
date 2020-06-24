package in.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudOrderProducerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudOrderProducerAppApplication.class, args);
	}

}
