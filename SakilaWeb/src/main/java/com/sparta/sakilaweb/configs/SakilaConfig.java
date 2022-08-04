package com.sparta.sakilaweb.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableWebSecurity
@Configuration
public class SakilaConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Jeff")
                .password("{noop}secret123")
                .authorities("USER");
        auth.inMemoryAuthentication()
                .withUser("Kira")
                .password("{noop}passw0rd")
                .authorities("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/cast/add/*").hasAnyAuthority("ADMIN")
                .antMatchers("/actor/*").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/welcome", true)
                    .permitAll()
                .and().exceptionHandling().accessDeniedPage("/accessDenied");
    }
}
