package in.nit.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cust")
public class CustomerRestController {

	@Value("${server.port}")
	private int port;

	@GetMapping("/status")
	public String showData() {
		 return "FINISHED:\"Hello from Customer Provider\":"+port;
	}
}
