package in.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nit.consumer.OrderRestConsumer;

@RestController
public class PaymentRestController {

	@Autowired
	private OrderRestConsumer consumer;

	@GetMapping("/payment")
	public String showPaymentData() {
		return "FROM PAYMENT=>"+consumer.connectToOrder();
	}
}
