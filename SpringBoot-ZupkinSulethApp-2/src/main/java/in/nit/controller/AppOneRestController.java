package in.nit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AppOneRestController {

	
	private static Logger log=LoggerFactory.getLogger(AppOneRestController.class); 
	@Autowired
	private RestTemplate rt;
	
	@GetMapping("/showB")
	public String showB() {
		log.info("APP-ONE-ENTER");
		String msg=rt.getForObject("http://localhost:9903/showC", String.class);

		log.info("APP-TWO-EXIT=>"+msg);

		return "DONE";
	}
}
