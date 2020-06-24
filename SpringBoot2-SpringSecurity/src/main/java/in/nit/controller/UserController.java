package in.nit.controller;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import in.nit.model.User;
import in.nit.service.IUserService;

@Controller
@SessionAttributes({ "mydte", "userRoles", "infoData" })

public class UserController {

	@Autowired
	private IUserService service;

	@GetMapping("/register")
	public String showRegister() {
		return "UserRegister";
	}

	@PostMapping("/save")
	public String saveUser(@ModelAttribute User user, Model model) {

		Integer id = service.saveUser(user);
		String message = "User '" + id + "' Saved";
		model.addAttribute("message", message);
		return "UserRegister";
	}

	// ----------------------
	@GetMapping("/home")
	public String showLogin() {
		return "HomePage";
	}

	@GetMapping("/admin")
	public String showAdmin(Principal p, Model model) {
		String un = p.getName();
		System.out.println(p.getClass().getName());

		model.addAttribute("un", un);
		model.addAttribute("mydte", new Date());
		return "AdminPage";
	}

	@GetMapping("/mgr")
	public String showEmp(Model model) {
		model.addAttribute("mydte", new Date());
		return "ManagerPage";
	}

	@GetMapping("/login")
	public String showLoginPage() {
		return "LoginPage";
	}

	@GetMapping("/common")
	public String showCommon(Model model) {
		model.addAttribute("mydte", new Date());
		return "CommonPage";
	}

	@GetMapping("/denied")
	public String showNoAccess() {
		return "DeniedPage";
	}

}
