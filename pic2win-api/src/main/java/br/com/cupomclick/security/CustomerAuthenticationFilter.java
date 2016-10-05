package br.com.cupomclick.security;

import br.com.cupomclick.domain.customer.Customer;
import br.com.cupomclick.service.AuthenticationResolver;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public CustomerAuthenticationFilter(AuthenticationResolver authenticationResolver) {
        this.authenticationResolver = authenticationResolver;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String xAuth = request.getHeader("Authorization");

        if(xAuth != null && xAuth.length() > 0) {


            Customer customer = authenticationResolver.authenticate(xAuth);

            if (customer == null) {
                response.setStatus(401);
                return;
            }
            // Create our Authentication and let Spring know about it
            Authentication auth = new CustomerAuthenticationToken(customer);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        filterChain.doFilter(request, response);
    }

}