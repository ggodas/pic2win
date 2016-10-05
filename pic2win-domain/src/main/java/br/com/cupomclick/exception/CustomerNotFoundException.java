package br.com.cupomclick.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by georgegodas on 22/09/16.
 */
public class CustomerNotFoundException extends AuthenticationException {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
