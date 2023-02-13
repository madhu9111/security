package com.slokam.sec;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.web.servlet.CsrfDsl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CsrfToken;
@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
public class SecurityConfigration extends WebSecurityConfigurerAdapter {

	@Override
		protected void configure(HttpSecurity http) throws Exception {
	
		http
		.csrf().disable()
        .authorizeRequests()
        .antMatchers(HttpMethod.GET, "/api/**").permitAll()
        .antMatchers("/api/auth/**").permitAll()
        .anyRequest()
        .authenticated();

	}
	
	
	
  @Override
  @Bean
  	protected UserDetailsService userDetailsService() {
  	
	  UserDetails userdetails = User.builder()
			  
			  .username("slokam")
			  .password("{noop}sloakm")
			  .roles("USER")
			  .build();
 UserDetails user = User.builder()
			  
			  .username("user")
			  .password("{noop}user")
			  .roles("ADMIN")
			  .build();
	   return new InMemoryUserDetailsManager(userdetails,user);
	  
  		
  	}	
	
}
