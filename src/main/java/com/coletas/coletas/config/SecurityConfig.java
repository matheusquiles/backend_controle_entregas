package com.coletas.coletas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class SecurityConfig {
	 @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    
	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .cors()  // Habilitar CORS
	            .and()
	            .csrf().disable()  // Desabilitar CSRF se necessário
	            .authorizeRequests()
	            .anyRequest().permitAll();  // Permitir acesso a todas as rotas sem autenticação

	        return http.build();
	    }
	    
	    @Bean
	    public CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration configuration = new CorsConfiguration();
	        configuration.addAllowedOrigin("https://select-data-site-6427d5c68d55.herokuapp.com"); // frontend URL
	        configuration.addAllowedOrigin("http://localhost:3000"); // URL local do frontend
	        configuration.addAllowedMethod("*"); // Permitir todos os métodos (GET, POST, etc.)
	        configuration.addAllowedHeader("*"); // Permitir todos os headers
	        configuration.setAllowCredentials(true); // Se você precisa passar cookies/autenticação

	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration); // Aplicar a todas as rotas
	        return source;
	    }
	    
	    @Bean
	    public CorsFilter corsFilter() {
	        return new CorsFilter(corsConfigurationSource());
	    }

}
