package in.nit.producer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeRestProducer {

	@GetMapping("/show")
	public String showMsg() {
		return "FROM PRODUCER";
	}
}
