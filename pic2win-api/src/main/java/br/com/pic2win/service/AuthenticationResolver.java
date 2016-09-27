package br.com.pic2win.service;

import br.com.pic2win.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by georgegodas on 01/09/16.
 */
@Component
public class AuthenticationResolver {

    private IAuthenticationService promoscanAuth;
    private IAuthenticationService facebookAuth;

    @Autowired
    public AuthenticationResolver(
            @Qualifier("PromoscanAuth") IAuthenticationService promoscanAuth,
            @Qualifier("FacebookAuth") IAuthenticationService facebookAuth) {
        this.promoscanAuth = promoscanAuth;
        this.facebookAuth = facebookAuth;
    }

    public Customer authenticate(String token){
        String[] base64Credentials = token.split(" ");
        String authenticationType = base64Credentials[0];
        String base64Authorization = base64Credentials[1];

        if (authenticationType.toUpperCase().indexOf("BASIC") >= 0){
            return promoscanAuth.authenticate(base64Authorization);
        } else if(authenticationType.toUpperCase().indexOf("FACEBOOK") >= 0){
            return facebookAuth.authenticate(base64Authorization);
        }
        return null;
    }
}
