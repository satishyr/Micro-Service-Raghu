package in.nit.service;

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

@Service
public class UserServiceImpl implements IUserService,UserDetailsService{
	@Autowired
	private UserRepository repo;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public Integer saveUser(User user) {
		String pwd=user.getUserPwd();
		pwd=encoder.encode(pwd);
		user.setUserPwd(pwd);
		return repo.save(user).getId();
	}

	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException 
	{
		// get model class user based on username
		User user=repo.findByUserName(username);
		
		//Roles to Set<GA>
		Set<GrantedAuthority> authorities=new HashSet<>();
		List<String> roles=user.getRoles();
		for(String role:roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		
		// return Spring f/w User
		org.springframework.security.core.userdetails.User usr=
				new org.springframework.security.core.userdetails.User(
						user.getUserName(), user.getUserPwd(), authorities);
		return usr;
	}
	
	
}
