package com.UserServices.UserService.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
@Configuration
public class AppConfig {
	
	@Bean
	public UserDetailsService userDetailService() 
	{
		UserDetails u1=User.builder().username("Ashish").password(passwordEncoder().encode("a")).roles("ADMIN").build();
		UserDetails u2=User.builder().username("SitaRam ji").password(passwordEncoder().encode("ShreeRam ji")).roles("ADMIN").build();

		return new InMemoryUserDetailsManager(u1,u2 );
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() 
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
	

}
