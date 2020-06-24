package in.nit.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomerRestConsumer {

	@Autowired  
	private LoadBalancerClient client;  
	public String getStatus()   {   
		String path="/cust/status";                        
		//Choose Service instance based on SID   
		ServiceInstance instance=client.choose("CUSTOMER-SERVICE");                        
		//Read URI from instance   
		String  uri=instance.getUri().toString();                        
		//Make http Request   
		RestTemplate  rt = new RestTemplate();   
		ResponseEntity <String>   resp=rt.getForEntity(uri+path, String.class);   
		return "CONSUMER=>"+resp.getBody(); 		
	}
}
