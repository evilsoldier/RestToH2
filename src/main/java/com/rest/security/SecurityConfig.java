package com.rest.security;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@ConditionalOnProperty(name = "enable.application.security", havingValue = "true")
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	                .withUser("user").password("passw0rd").roles("USER")
	                .and()
	                .withUser("user2").password("secret2").roles("USER");
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests().anyRequest().fullyAuthenticated();
	        http.httpBasic();
	        http.csrf().ignoringAntMatchers("/post");
	    }
}
