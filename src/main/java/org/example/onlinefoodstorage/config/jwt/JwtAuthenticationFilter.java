//package org.example.onlinefoodstorage.config.jwt;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.example.onlinefoodstorage.entity.auth.Auth;
//import org.example.onlinefoodstorage.exceptions.customExceptions.NotFoundException;
//import org.example.onlinefoodstorage.repository.auth.AuthRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.Optional;
//
//@Component
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    private final JwtTokenProvider jwtTokenProvider;
//    private final AuthRepository authRepository;
//
//    @Autowired
//    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider, AuthRepository authRepository) {
//        this.jwtTokenProvider = jwtTokenProvider;
//        this.authRepository = authRepository;
//    }
//
//    public String getJwtFromRequest(HttpServletRequest request) {
//        String bearerToken = request.getHeader("Authorization");
//        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
//            return bearerToken.substring(7);
//        }
//        return null;
//    }
//
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String jwt = getJwtFromRequest(request);
//
//        if (jwt != null && jwtTokenProvider.validateToken(jwt)) {
//            String phone = jwtTokenProvider.getUserIdFromJWT(jwt);
//            Optional<Auth> accountOptional = authRepository.findByPhone(phone);
//
//            if (accountOptional.isPresent()) {
//                Auth user = accountOptional.orElseThrow(() -> new NotFoundException("User not found"));
//                UsernamePasswordAuthenticationToken usernameToken = new UsernamePasswordAuthenticationToken(
//                        user,
//                        null,
//                        user.getAuthorities()
//                );
//                SecurityContextHolder.getContext().setAuthentication(usernameToken);
//            }
//        }
//
//        filterChain.doFilter(request, response);
//    }
//}
