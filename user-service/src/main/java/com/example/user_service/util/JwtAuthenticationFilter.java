// package com.example.user_service.util;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.stereotype.Component;
// import org.springframework.util.StringUtils;
// import org.springframework.web.filter.OncePerRequestFilter;

// import javax.servlet.FilterChain;
// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import java.io.IOException;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

// @Component
// public class JwtAuthenticationFilter extends OncePerRequestFilter {

//     private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

//     @Autowired
//     private JwtTokenProvider jwtTokenProvider; // Assuming you have a JwtTokenProvider for JWT parsing and validation

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//             throws ServletException, IOException {

//         try {
//             // Extract the JWT token from the Authorization header
//             String token = getJwtFromRequest(request);

//             // Validate the token and set the authentication in the security context
//             if (StringUtils.hasText(token) && jwtTokenProvider.validateToken(token)) {
//                 Authentication authentication = jwtTokenProvider.getAuthentication(token);
//                 SecurityContextHolder.getContext().setAuthentication(authentication);
//             }
//         } catch (Exception ex) {
//             // Log and suppress exceptions to avoid breaking the filter chain
//             logger.error("Could not set user authentication in security context", ex);
//         }

//         // Proceed with the filter chain (allowing the request to continue)
//         filterChain.doFilter(request, response);
//     }

//     /**
//      * Extracts the JWT token from the Authorization header.
//      *
//      * @param request the HTTP request
//      * @return the JWT token or null if the header is missing or invalid
//      */
//     private String getJwtFromRequest(HttpServletRequest request) {
//         String bearerToken = request.getHeader("Authorization");
//         if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
//             return bearerToken.substring(7); // Remove "Bearer " prefix and return the token
//         }
//         return null;
//     }
// }
