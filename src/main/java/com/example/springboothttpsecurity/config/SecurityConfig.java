package com.example.springboothttpsecurity.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@org.springframework.context.annotation.Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.formLogin();

        http.authorizeRequests()
                .antMatchers("/club/**").permitAll()
                .antMatchers("/students").permitAll()
                .antMatchers("/student/**").permitAll()
                .antMatchers("/create/student/**").permitAll()
                .antMatchers("/**").hasRole("manager")
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}
