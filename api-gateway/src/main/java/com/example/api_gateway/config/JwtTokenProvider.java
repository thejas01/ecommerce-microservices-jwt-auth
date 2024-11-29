package com.example.api_gateway.config;



import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import javax.crypto.SecretKey;

@Component
public class JwtTokenProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);
    
    private SecretKey generateKey() {
        return Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }
    public String generateToken(String username) {
        SecretKey secretKey = generateKey();
        // Use the secure key to sign the JWT
        return Jwts.builder()
                   .setSubject(username)
                   .signWith(secretKey)
                   .compact();
    }
    @Autowired
    private JwtProperties jwtProperties; // Inject JwtProperties class

    // public String generateToken(String username) {
    //     return Jwts.builder()
    //             .setSubject(username)
    //             .setIssuedAt(new Date())
    //             .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpiration()))
    //             .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret())
    //             .compact();
    // }

    public String getUsernameFromToken(String token) {
        try {
            // Updated code for JWT parsing using the new API
            return Jwts.parserBuilder()
                    .setSigningKey(jwtProperties.getSecret())   // Set the secret key for parsing
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (JwtException | IllegalArgumentException e) {
            logger.error("Failed to parse token: {}", token, e);
            return null;
        }
    }

    public boolean validateToken(String token) {
        try {
            // Updated code for JWT validation using the new API
            Jwts.parserBuilder()
                    .setSigningKey(jwtProperties.getSecret()) // Set the secret key for parsing
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            logger.error("Invalid JWT token: {}", token, e);
            return false;
        }
    }
}
