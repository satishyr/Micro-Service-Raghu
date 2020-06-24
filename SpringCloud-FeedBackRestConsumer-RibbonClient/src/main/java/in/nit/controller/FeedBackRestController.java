package in.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nit.consumer.CustomerRestConsumer;

@RestController
@RequestMapping("/feed")
public class FeedBackRestController {

	@Autowired
	private CustomerRestConsumer consumer;
	
	@GetMapping("/info")
	public String feedBackMsg(){
		return "FEOM FEEDBACK=>"+consumer.getStatus();
	}
}
