package br.com.cupomclick.security;

import br.com.cupomclick.domain.customer.Customer;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by georgegodas on 22/09/16.
 */
public class CustomerAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = -1949976839306453197L;
    private Customer customer;

    public CustomerAuthenticationToken(Customer customer){
        super(Arrays.asList());
        this.customer = customer;
    }

    public CustomerAuthenticationToken(Collection<? extends GrantedAuthority> authorities, Customer customer) {
        super(authorities);
        this.customer = customer;
    }

    @Override
    public Object getCredentials() {
        return customer.getPassword();
    }

    @Override
    public Object getPrincipal() {
        return customer;
    }
}
