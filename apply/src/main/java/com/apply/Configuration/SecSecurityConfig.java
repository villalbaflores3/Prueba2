package com.apply.Configuration;

import com.apply.Models.Dao.EmpleadoReporsitory;
import com.apply.Services.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
@EnableJpaRepositories(basePackageClasses = EmpleadoReporsitory.class )
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecSecurityConfig  extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private CustomUserDetailsService userDetailsService;
    private HttpSecurity http;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    
        auth.userDetailsService(userDetailsService)
        .passwordEncoder(new PasswordEncoder(){

            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence arg0, String arg1) {
                // TODO Auto-generated method stub
                return true;
            }


                

        });
    }



/*
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{

        PasswordEncoder enconder =  passwordEncoder();
        UserBuilder users  = User.builder().passwordEncoder(enconder :: encode);
        builder.inMemoryAuthentication()
        .withUser(users.username("Admin").password("123").roles("ADMIN", "USER"))
        .withUser(users.username("Alejandra").password("123").roles("USER"));
    }

*/  
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/assets/**","/proveedores").permitAll().
        antMatchers("/admin/**").access("hasRole('ADMIN')").   
        antMatchers("/empleado/*").access("hasRole('ADMIN')").   
        antMatchers("/user/**").hasAnyRole("ADMIN", "USER").
        anyRequest().authenticated().
        and().
        formLogin().loginPage("/login").defaultSuccessUrl("/user", true).permitAll().
        and().
        logout().permitAll().and()
        .exceptionHandling().accessDeniedPage("/error_403");


    }




}
