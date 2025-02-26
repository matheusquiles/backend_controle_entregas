package com.coletas.coletas.token;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.coletas.coletas.service.SecurityUserService;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    
    @Autowired
    private SecurityUserService securityUserService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String requestTokenHeader = request.getHeader("Authorization");
        logger.info("🔍 Authorization Header recebido: " + requestTokenHeader);

        String username = null;
        String jwtToken = null;

        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
            logger.info("🔑 Extraído Token JWT: " + jwtToken);
            try {
                username = jwtTokenUtil.getUsernameFromToken(jwtToken);
                logger.info("👤 Usuário extraído do token: " + username);
            } catch (IllegalArgumentException e) {
                logger.error("❌ Não foi possível obter o JWT Token");
            } catch (ExpiredJwtException e) {
                logger.error("❌ JWT Token expirado");
            }
        } else {
            logger.warn("⚠️ JWT Token não começa com 'Bearer '");
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = securityUserService.loadUserByUsername(username);
            logger.info("✅ UserDetails carregado para: " + userDetails.getUsername());

            if (jwtTokenUtil.validateToken(jwtToken, userDetails.getUsername())) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                logger.info("🔓 Autenticação configurada no SecurityContext");
            } else {
                logger.warn("🚫 Token inválido para usuário: " + username);
            }
        }
        
        chain.doFilter(request, response);
    }
}
