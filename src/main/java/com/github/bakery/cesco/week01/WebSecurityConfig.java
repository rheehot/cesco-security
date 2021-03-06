package com.github.bakery.cesco.week01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .mvcMatchers("/", "/info").permitAll()
            .mvcMatchers("/admin").hasRole("ADMIN")
            .anyRequest()
            .authenticated();

        http.formLogin();
        http.httpBasic();
        http.csrf().disable();
    }

    /**
     * TODO 1주차 과제
     * ADMIN / USER Role 각각 InMemory 로 생성하자..!!
     */
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//    }

}
