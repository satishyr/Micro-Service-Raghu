package in.nit.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("VENDOR-CONSUMER")
public interface VendorRestConsumer {

	@GetMapping("/vendor/data")
	public String getVendorData();
}
