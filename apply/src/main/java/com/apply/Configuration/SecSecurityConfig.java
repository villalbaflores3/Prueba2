package com.apply.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
public class SecSecurityConfig  extends WebSecurityConfigurerAdapter{
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }


    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{

        PasswordEncoder enconder =  passwordEncoder();
        UserBuilder users  = User.builder().passwordEncoder(enconder :: encode);
        builder.inMemoryAuthentication()
        .withUser(users.username("admin").password("123").roles("ADMIN", "USER"))
        .withUser(users.username("alejandra").password("123").roles("USER"));
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/assets/**").permitAll().
        antMatchers("admin/*").access("hasRole('ADMIN')").   
        antMatchers("empleado/*").access("hasRole('ADMIN')").   
        antMatchers("/user/**").hasAnyRole("ADMIN", "USER").
        anyRequest().authenticated().
        and().
        formLogin().loginPage("/login").defaultSuccessUrl("/user", true).permitAll().
        and().
        logout().permitAll().and()
        .exceptionHandling().accessDeniedPage("/error_403");


    }


    /*
    protected void configure(HttpSecurity http) throws Exception {
    
    http.
    authorizeRequests().any

    }*/
    


}
