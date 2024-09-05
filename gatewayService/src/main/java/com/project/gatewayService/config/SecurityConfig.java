package com.project.gatewayService.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	  private final String[] freeResourceUrls = {"/eureka/**","/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**",
    "/swagger-resources/**", "/api-docs/**", "/aggregate/**", "/actuator/prometheus","/error"};

	
	  @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf->csrf.disable())
            .authorizeHttpRequests(auth->{
            	auth.requestMatchers(freeResourceUrls).permitAll();
//            	auth.requestMatchers("/service").hasRole("USER");
            	auth.anyRequest().authenticated();
            })
            .oauth2ResourceServer(auth2->auth2
            		.jwt(Customizer.withDefaults()));
//        .jwtAuthenticationConverter(jwtAuthenticationConverter()); 
        return http.build();
    }
	  

//private JwtAuthenticationConverter jwtAuthenticationConverter() {
//    JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
//    jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwt -> {
//        Collection<GrantedAuthority> authorities = new ArrayList<>();  // Use Collection<GrantedAuthority>
//        
//        // Extract roles from the JWT (Keycloak realm_access claim)
//        Map<String, Object> realmAccess = (Map<String, Object>) jwt.getClaims().get("realm_access");
//        if (realmAccess != null && realmAccess.containsKey("roles")) {
//            Collection<String> roles = (Collection<String>) realmAccess.get("roles");
//            roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role)));
//        }
//
//        return authorities;
//    });
//    return jwtAuthenticationConverter;
//}
}
