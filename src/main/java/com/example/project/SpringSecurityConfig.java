package com.example.project;

import org.springframework.context.annotation.*;
import org.springframework.beans.factory.annotation.*;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration

@EnableWebSecurity

public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired

    private AuthenticationEntryPoint authEntryPoint;



    @Override

    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeRequests()

                .anyRequest().authenticated()

                .and().httpBasic()

                .authenticationEntryPoint(authEntryPoint);

    }



    @Autowired

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().withUser("username").password("password").roles("USER");

    }




}
