package com.proyecto2.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.proyecto2.demo.service.UserService;

@Configuration
public class SpringSecurityConfig {
    
    @Autowired
    private UserService userService;

    public static BCryptPasswordEncoder encriptarPassword(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeRequests()
        .anyRequest().authenticated()
        .and().formLogin().loginPage("/").defaultSuccessUrl("/admi",true).permitAll()
        .and().logout().permitAll();
        return http.build();
    }
    @Autowired
    public void criptografiaPassword(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(encriptarPassword());
    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() throws Exception{
        return (web) ->web.ignoring().antMatchers("/css/**","/js/**","/images/**");
    }
    }


