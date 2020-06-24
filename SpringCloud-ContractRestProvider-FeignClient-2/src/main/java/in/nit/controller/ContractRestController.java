package in.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nit.consumer.VendorRestConsumer;

@RestController
@RequestMapping("/contract")
public class ContractRestController {

	@Autowired
	private VendorRestConsumer consumer;
	
	@GetMapping("/info")
	public String viewContractData() {
		return "FROM CONTRACT=>"+consumer.getVendorData();
	}
}
