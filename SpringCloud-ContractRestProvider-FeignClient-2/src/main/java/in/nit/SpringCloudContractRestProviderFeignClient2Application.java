package in.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SpringCloudContractRestProviderFeignClient2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudContractRestProviderFeignClient2Application.class, args);
	}

}
