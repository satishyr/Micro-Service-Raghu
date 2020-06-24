package in.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudCustomerRestProducerRibbonClient1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudCustomerRestProducerRibbonClient1Application.class, args);
	}

}
