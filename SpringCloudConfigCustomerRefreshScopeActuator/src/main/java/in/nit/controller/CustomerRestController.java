package in.nit.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class CustomerRestController {
	@Value("${my.app.name}")
	private String data;
	
	@GetMapping("/customer")
	public String show() {
		return "FROM CUSTOMER=>"+data;
	
}
}