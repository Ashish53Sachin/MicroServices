package com.UserServices.UserService.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.UserServices.UserService.Security.JwtAuthenticationEntryPoint;
import com.UserServices.UserService.Security.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {
	
	@Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;

    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	
//    	httpSecurity.csrf(AbstractHttpConfigurer::disable)
//    	.authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests.requestMatchers("/home/**")
//    			.authenticated()
//                .requestMatchers("/auth/login").hasRole("ADMIN").
//    			anyRequest().authenticated()).exceptionHandling(ex -> ex.authenticationEntryPoint(point))
//        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//  httpSecurity.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
//    	.formLogin(Customizer.withDefaults());


//
        http.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable())
                .authorizeHttpRequests(auth -> auth.requestMatchers("/home/**").authenticated()
                .requestMatchers("/auth/login").permitAll()
                .anyRequest()
                .authenticated())
                .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
  return http.build();
    }

}
