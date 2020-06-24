package in.nit.util;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	@Value("${app.secret}")
	private String secret;
	
	//6. Validate user,tokenExp
	public boolean validateToken(String token,String username) {
		String tokenUser=getUsername(token);
		//user must be matching and token should not expiared
		return (tokenUser.equals(username) && !isTokenExp(token));
	}
	
	//5. token Exp check
	public boolean isTokenExp(String token) {
		return getExpDate(token).before(new Date(System.currentTimeMillis()));
	}
	
	//4. Read Exp Date 
	public Date getExpDate(String token) {
		return getClaims(token).getExpiration();
	}
	
	//3. read username(subject)
	public String getUsername(String token) {
		return getClaims(token).getSubject();
	}
	
	//2. Get claims
	public Claims getClaims(String token) {
		return Jwts.parser()
				.setSigningKey(Base64.getEncoder().encode(secret.getBytes()))
				.parseClaimsJws(token)
				.getBody();
	}
	
	//1. Generate Token using subject
	public String generateToken(String subject) {
		return Jwts.builder()
				.setSubject(subject)
				.setIssuer("NareshIT")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() 
						 + TimeUnit.MINUTES.toMillis(10)) )
				.signWith(SignatureAlgorithm.HS256, 
						 Base64.getEncoder().encode(secret.getBytes()))
				.compact();
				
	

}
}