package in.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudNativePaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudNativePaymentApplication.class, args);
	}

}
