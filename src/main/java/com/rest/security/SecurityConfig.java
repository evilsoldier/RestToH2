package com.rest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomAuthenticationProvider customAuthProvider;

    @Autowired
    public SecurityConfig(CustomAuthenticationProvider customAuthProvider) {
        this.customAuthProvider = customAuthProvider;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(customAuthProvider);
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .authorities("ROLE_USER");
    }

    /**
     * Change below in order to enable security
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic()
//                .and().authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/h2_console/**").permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();

//        http.authorizeRequests()
//                .antMatchers("/h2_console/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}