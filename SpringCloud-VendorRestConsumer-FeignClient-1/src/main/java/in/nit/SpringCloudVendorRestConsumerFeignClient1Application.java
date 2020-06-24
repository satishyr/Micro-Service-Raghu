package in.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudVendorRestConsumerFeignClient1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudVendorRestConsumerFeignClient1Application.class, args);
	}

}
