// package com.example.authentication_service.config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import com.example.authentication_service.filter.JwtFilter;
 
// import com.example.authentication_service.util.JwtUtil;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     private final MyUserDetailsService myUserDetailsService;
//     private final JwtUtil jwtUtil;

//     public SecurityConfig(MyUserDetailsService myUserDetailsService, JwtUtil jwtUtil) {
//         this.myUserDetailsService = myUserDetailsService;
//         this.jwtUtil = jwtUtil;
//     }

//     protected void configure(HttpSecurity http) throws Exception {
//         http.csrf(csrf -> csrf.disable())
//                 .authorizeRequests(requests -> requests
//                         .requestMatchers("/authenticate").permitAll()  // Permit access to authentication endpoint
//                         .anyRequest().authenticated()  // All other endpoints need authentication
//                         .and()
//                         .addFilterBefore(new JwtFilter(jwtUtil, myUserDetailsService), UsernamePasswordAuthenticationFilter.class));  // Add JwtFilter before the UsernamePasswordAuthenticationFilter
//     }
// }
