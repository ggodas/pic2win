package br.com.pic2win.security;

import br.com.pic2win.service.AuthenticationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * Created by georgegodas on 22/09/16.
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class CustomerSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomerAuthenticationProvider customerAuthenticationProvider;
    @Autowired
    private AuthenticationResolver authenticationResolver;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                //.antMatchers(HttpMethod.POST, "/api/**").authenticated()
                .antMatchers(HttpMethod.PUT, "/api/**").authenticated()
                .antMatchers(HttpMethod.DELETE, "/api/**").authenticated()
                .and()
                .addFilterBefore(new CustomerAuthenticationFilter(authenticationResolver), BasicAuthenticationFilter.class)
        ;

    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity
                .ignoring()
                .antMatchers(HttpMethod.POST, "/api/**");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customerAuthenticationProvider);
    }

}