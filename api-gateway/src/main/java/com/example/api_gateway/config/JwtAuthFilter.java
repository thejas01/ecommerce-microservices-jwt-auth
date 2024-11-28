// package com.example.api_gateway.config;

// import org.springframework.http.HttpHeaders;
// import org.springframework.stereotype.Component;
// import org.springframework.web.server.ServerWebExchange;
// import org.springframework.web.server.WebFilter;
// import org.springframework.web.server.WebFilterChain;

// import com.example.api_gateway.utils.JwtUtil;

// import reactor.core.publisher.Mono;

// @Component
// public class JwtAuthFilter implements WebFilter {

//     private final JwtUtil jwtUtil;

//     public JwtAuthFilter(JwtUtil jwtUtil) {
//         this.jwtUtil = jwtUtil;
//     }

//     @Override
//     public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
//         String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
//         if (authHeader != null && authHeader.startsWith("Bearer ")) {
//             String token = authHeader.substring(7);
//             String username = jwtUtil.extractUsername(token);

//             if (jwtUtil.isTokenValid(token, username)) {
//                 exchange.getRequest().mutate().header("X-Authenticated-User", username).build();
//             }
//         }
//         return chain.filter(exchange);
//     }
// }
