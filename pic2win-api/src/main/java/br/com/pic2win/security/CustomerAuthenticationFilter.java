package br.com.pic2win.security;

import br.com.pic2win.service.AuthenticationResolver;
import br.com.pic2win.Customer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by georgegodas on 22/09/16.
 */
@Component("CustomerAuthenticationFilter")
public class CustomerAuthenticationFilter  extends OncePerRequestFilter {

    private AuthenticationResolver authenticationResolver;

    public CustomerAuthenticationFilter(AuthenticationResolver authenticationResolver) {
        this.authenticationResolver = authenticationResolver;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String xAuth = request.getHeader("Authorization");

        if(xAuth == null || xAuth.length() == 0){
            response.setStatus(400);
            return;
        }

        Customer customer = authenticationResolver.authenticate(xAuth);

        if(customer == null){
            response.setStatus(401);
            return;
        }
        // Create our Authentication and let Spring know about it
        Authentication auth = new CustomerAuthenticationToken(customer);
        SecurityContextHolder.getContext().setAuthentication(auth);

        filterChain.doFilter(request, response);
    }

}