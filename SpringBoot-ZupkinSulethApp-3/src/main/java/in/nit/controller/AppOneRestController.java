package in.nit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppOneRestController {

	
	private static Logger log=LoggerFactory.getLogger(AppOneRestController.class); 
	@GetMapping("/showC")
	public String showC() {
		log.info("APP-ONE-ENTER");

		log.info("APP-THREE-EXIT");

		return "APP-THREE-DONE";
	}
}
