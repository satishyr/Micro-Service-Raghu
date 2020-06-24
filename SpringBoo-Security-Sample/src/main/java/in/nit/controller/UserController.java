package in.nit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping({"/home","/"})
	public String showHome() {
		return "HomePage";
	}
	
	@RequestMapping("/inbox")
	public String showInbox() {
		
		return "Inbox";
	}
}
