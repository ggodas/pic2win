package br.com.promoscan.security;

import br.com.promoscan.Customer;
import br.com.promoscan.exception.CustomerNotFoundException;
import br.com.promoscan.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Created by georgegodas on 22/09/16.
 */
@Component
public class CustomerAuthenticationProvider implements AuthenticationProvider {

    // This would be a JPA repository to snag your user entities
    private final CustomerService customerService;

    @Autowired
    public CustomerAuthenticationProvider(CustomerService customerService) {
        this.customerService = customerService;
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        CustomerAuthenticationToken demoAuthentication = (CustomerAuthenticationToken) authentication;
        Customer customer = (Customer) demoAuthentication.getPrincipal();

        if(customer == null){
            throw new CustomerNotFoundException("Usuario nao encontrado");
        }

        return demoAuthentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomerAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
