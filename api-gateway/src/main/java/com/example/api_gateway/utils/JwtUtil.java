// package com.example.api_gateway.utils;
// import java.util.Date;
// import java.util.function.Function;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;

// public class JwtUtil {

//     private final String secret = "your_secret_key"; // Use a secure key

//     @SuppressWarnings("deprecation")
//     public String generateToken(String username) {
//         return Jwts.builder()
//                 .setSubject(username)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
//                 .signWith(SignatureAlgorithm.HS256, secret)
//                 .compact();
//     }

//     public String extractUsername(String token) {
//         return extractClaim(token, Claims::getSubject);
//     }

//     public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//         final Claims claims = extractAllClaims(token);
//         return claimsResolver.apply(claims);
//     }

//     @SuppressWarnings("deprecation")
//     private Claims extractAllClaims(String token) {
//         return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//     }

//     public boolean isTokenValid(String token, String username) {
//         final String extractedUsername = extractUsername(token);
//         return (extractedUsername.equals(username) && !isTokenExpired(token));
//     }

//     private boolean isTokenExpired(String token) {
//         return extractAllClaims(token).getExpiration().before(new Date());
//     }
    
// }
