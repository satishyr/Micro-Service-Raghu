package in.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nit.model.User;
import in.nit.model.UserRequest;
import in.nit.model.UserResponse;
import in.nit.service.IUserService;
import in.nit.util.JwtUtil;

@RestController
@RequestMapping("/user")
public class UserRestController {
	@Autowired
	private IUserService service;
	@Autowired
	private JwtUtil jwtUtil;

	/**
	 * It will verify user/pwd on request
	 */
	@Autowired
	private AuthenticationManager manager;

	//1. save user
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(
			@RequestBody User user)
	{
		Integer id=service.saveUser(user);
		return ResponseEntity.ok("User saved with id:"+id);
	}

	//2. validate login user
	@PostMapping("/login")
	public ResponseEntity<UserResponse> loginCheck(
			@RequestBody UserRequest userRequest)
	{
		/** It will cross check user data with DB Using UserDetailsService**/
		manager.authenticate(
				new UsernamePasswordAuthenticationToken(
						userRequest.getUsername(), 
						userRequest.getPassword()
						)
				);
		
		//gerenate token 
		String token=jwtUtil.generateToken(userRequest.getUsername());
		//give respose
		return ResponseEntity.ok(new UserResponse("SUCCESS",token));
	}
}
