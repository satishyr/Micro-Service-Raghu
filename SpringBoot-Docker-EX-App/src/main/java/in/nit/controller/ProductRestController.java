package in.nit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {

	@GetMapping("/show")
	public String show() {
		return "From Product RestController";
	}
}
