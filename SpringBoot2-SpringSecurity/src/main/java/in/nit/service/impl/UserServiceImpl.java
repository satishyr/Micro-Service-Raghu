package in.nit.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.nit.model.User;
import in.nit.repo.UserRepository;
import in.nit.service.IUserService;

@Service
public class UserServiceImpl implements IUserService,UserDetailsService{

	@Autowired
	private UserRepository repo;
	@Autowired
	private BCryptPasswordEncoder encode;
	@Override
   public Integer saveUser(User user) {
		//reading user pwd
		String pwd=user.getUserPwd();
		//convert into unreadable format
		pwd=encode.encode(pwd);
		//set back to model class object
		user.setUserPwd(pwd);
		//save in db
	return repo.save(user).getId();
}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		
		//1.Load Model Class User
		
		User user=repo.findByUserMail(username);
		
		//2. read roles from model class
		
		List<String> roles=user.getRoles();
		
		//3. create set for granted authority
		
		Set<GrantedAuthority> authorities=new HashSet<>();
		
		//4. convert string role to granted authority object
		for(String role:roles) {
			
			authorities.add(new SimpleGrantedAuthority(role));
		}
		
		//5. create spring security user class object
		org.springframework.security.core.userdetails.User uob=new org.springframework.security.core.userdetails.User(username, user.getUserPwd(), authorities);
		return uob;
	}
}
