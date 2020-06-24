package in.nit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity	
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	@Autowired
	private UserDetailsService service;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	auth.userDetailsService(service).passwordEncoder(pwdEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/register","/save","/home","/login").permitAll()
		.antMatchers("/admin").hasAuthority("ADMIN")
		.antMatchers("/mgr").hasAuthority("MANAGER")
		//.antMatchers("/common","/denied").authenticated()
		.anyRequest() //Remaining all URLs. Other then which are not provided above
		.authenticated()
		
		.and()
		.formLogin()
        .loginPage("/login")
		.defaultSuccessUrl("/common",true) //Success ful login -> true -> Common Page
		
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout")

		.and()
		.exceptionHandling()
		.accessDeniedPage("/denied");

	}
}
