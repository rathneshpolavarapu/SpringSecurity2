package com.example.demo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
     private UserDetailsService userDetailsService;


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf(csrfCustomizer->csrfCustomizer.disable());
		http.authorizeHttpRequests(authReq->authReq.requestMatchers("add-newuser").permitAll().anyRequest().authenticated());
		http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.httpBasic(Customizer.withDefaults());
	    return	http.build();
	}
     
     @Bean
     public AuthenticationProvider authProvider() {
    	 
    	 DaoAuthenticationProvider daoAuth= new DaoAuthenticationProvider();
    	 daoAuth.setUserDetailsService(userDetailsService);
//    	 daoAuth.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
    	 daoAuth.setPasswordEncoder(new BCryptPasswordEncoder(12));
    	 return daoAuth;
    	 
     }
	
//	@Bean
//	public UserDetailsService userDetails() {
//		
//		UserDetails user=User.withDefaultPasswordEncoder()
//				.username("chris")
//				.password("chris@25")
//				.roles("user")
//				.build(); 
//		
//		UserDetails admin=User.withDefaultPasswordEncoder()
//				.username("rama")
//				.password("rama@25")
//				.roles("admin")
//				.build();
//		
//		return new InMemoryUserDetailsManager(user,admin);
//	}
	
}
