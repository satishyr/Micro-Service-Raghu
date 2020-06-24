package in.nit.producer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderProducer {

	@GetMapping("/order")
	public String showOrderInfo()
	{
		return "FROM ORDER";
	}
}
