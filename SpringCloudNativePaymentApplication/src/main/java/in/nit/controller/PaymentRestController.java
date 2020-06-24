package in.nit.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentRestController {

	@Value("${my.app.code}")
	private String code;
	
	@GetMapping("/show")
	public String show() {
		return "Payment From=>"+code;
	}
}
