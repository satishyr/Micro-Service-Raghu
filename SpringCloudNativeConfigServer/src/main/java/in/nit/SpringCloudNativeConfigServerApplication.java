package in.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudNativeConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudNativeConfigServerApplication.class, args);
	}

}
