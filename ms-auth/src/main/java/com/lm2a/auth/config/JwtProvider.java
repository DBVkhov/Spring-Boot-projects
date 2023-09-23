package com.lm2a.auth.config;

import java.util.Base64;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.lm2a.auth.entity.UserEntity;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.annotation.PostConstruct;

@Component
public class JwtProvider {

	@Value("${jwt.secret}")
	private String secret;
	
	
	
	public void setSecret(String secret) {
		this.secret = secret;
	}


	@PostConstruct
	public void init() {
		secret = Base64.getEncoder().encodeToString(secret.getBytes());
	}
	
	
	public String createToken(UserEntity user) {
		Map<String, Object> claims = Jwts.claims().setSubject(user.getUsername());
		claims.put("id", user.getId());
		//TODO
		claims.put("company-name", "lm2a");
		claims.put("company-email", "info@lm2a.com");
		Date now = new Date();
		Date expiration = new Date(now.getTime()+3600*1000);
		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(now)
				.setExpiration(expiration)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}
	
	public boolean validate(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		} 
	}
	
	public String getUsernameFromToken(String token) {
		try {
			return Jwts.parser().setSigningKey(secret).parseClaimsJwt(token).getBody().getSubject();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid token");
		} 
	}
	
}
