package in.nit.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderRestConsumer {

	@Autowired
	private DiscoveryClient client;
	
	public String connectToOrder() {
		
		//1. Define RestTemplate
				RestTemplate rt=new RestTemplate();

				//2. Get ServiceInstance data using Service-Name/Application-Name
				List<ServiceInstance> siList=client.getInstances("ORDER-PROVIDER");

				//3. Read one Service Instance using index-0
				ServiceInstance si=siList.get(0);

				//4. Read URI and add path
				String URL = si.getUri()+"/order";

				//5. make HTTP Request
				String respMsg=rt.getForObject(URL, String.class);
				
				return respMsg;

	}
}
