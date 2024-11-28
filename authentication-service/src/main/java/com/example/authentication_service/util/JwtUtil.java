// package com.example.authentication_service.util;


// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import org.springframework.stereotype.Component;

// import java.util.Date;

// @Component
// public class JwtUtil {
//     private String secretKey = "secretKey";  // In production, use a more secure key

//     @SuppressWarnings("deprecation")
//     public String generateToken(String username) {
//         return Jwts.builder()
//                 .setSubject(username)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))  // 10 hours expiry
//                 .signWith(SignatureAlgorithm.HS256, secretKey)
//                 .compact();
//     }

//     public String extractUsername(String token) {
//         return extractClaim(token, Claims::getSubject);
//                     }
                
           
        
//             private <T> T extractClaim(String token, io.jsonwebtoken.Function<Claims, T> claimsResolver) {
//         final Claims claims = extractAllClaims(token);
//         return claimsResolver.apply(claims);
//     }

//     private Claims extractAllClaims(String token) {
//         return Jwts.parser()
//                 .setSigningKey(secretKey)
//                 .parseClaimsJws(token)
//                 .getBody();
//     }

//     public boolean isTokenExpired(String token) {
//         return extractExpiration(token).before(new Date());
//     }

//     private Date extractExpiration(String token) {
//         return extractClaim(token, Claims::getExpiration);
//     }

//     public boolean validateToken(String token, String username) {
//         return (username.equals(extractUsername(token)) && !isTokenExpired(token));
//     }
// }
