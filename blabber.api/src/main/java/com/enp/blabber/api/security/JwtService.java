package com.enp.blabber.api.security;

import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	//KEY FOR AUTHENTICATION
	//Use generateSecretKey method from de test folder to generate a new key
	private static final String API_ACCESS = "9D825B886551DBAC1F538E0EBAF987162644FEE1213D9E9B3B7D41D1A5C9BA7E454BD79F0EB12B5512A2B6F7BC9BCAB56C58307E85CAD3DF966A8FFEE19F3F7B";
	private static final long VALIDITY = TimeUnit.MINUTES.toMillis(60);
	
	public String generateToken(UserDetails userDetails) {
		Map<String,String> claims = new HashMap<>();
		claims.put("iss","bookmaster.api");
		return Jwts.builder()
			.claims(claims)
			.subject(userDetails.getUsername())
			.issuedAt(Date.from(Instant.now()))
			.expiration(Date.from(Instant.now().plusMillis(VALIDITY)))
			.signWith(generateKey())
			.compact();
	}
	
	private SecretKey generateKey() {
		byte[] decodedKey = Base64.getDecoder().decode(API_ACCESS);
		return Keys.hmacShaKeyFor(decodedKey);
	}
	
	public String extractUsername(String jwt) {
        Claims claims = getClaims(jwt);
        return claims.getSubject();
    }

    private Claims getClaims(String jwt) {
        return Jwts.parser()
                 .verifyWith(generateKey())
                 .build()
                 .parseSignedClaims(jwt)
                 .getPayload();
    }

    public boolean isTokenValid(String jwt) {
        Claims claims = getClaims(jwt);
        return claims.getExpiration().after(Date.from(Instant.now()));
    }

}
