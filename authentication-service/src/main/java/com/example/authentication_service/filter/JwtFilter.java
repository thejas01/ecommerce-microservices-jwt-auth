// package com.example.authentication_service.filter;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// import com.example.authentication_service.service.MyUserDetailsService;
// import com.example.authentication_service.util.JwtUtil;
// import org.springframework.web.filter.OncePerRequestFilter;


// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import java.io.IOException;

// @Component
// public class JwtFilter extends OncePerRequestFilter {

//     private final JwtUtil jwtUtil;
//     private final MyUserDetailsService userDetailsService;

    
//     public JwtFilter(JwtUtil jwtUtil, MyUserDetailsService userDetailsService) {
//         this.jwtUtil = jwtUtil;
//         this.userDetailsService = userDetailsService;
//     }

//     @Override
//     protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//         final String authorizationHeader = request.getHeader("Authorization");

//         String username = null;
//         String jwt = null;

//         if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//             jwt = authorizationHeader.substring(7);
//             username = jwtUtil.extractUsername(jwt);
//         }

//         if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//             UserDetails userDetails = userDetailsService.loadUserByUsername(username);

//             if (jwtUtil.validateToken(jwt, username)) {
//                 UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//                         userDetails, null, userDetails.getAuthorities());
//                 usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                 SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//             } else {
//                 response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                 response.getWriter().write("Invalid or expired token");
//                 return;
//             }
//         }

//         filterChain.doFilter(request, response);
//     }
// }
