package br.com.promoscan.service;

import br.com.promoscan.Customer;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Reading;
import facebook4j.auth.AccessToken;
import org.springframework.stereotype.Component;

/**
 * Created by georgegodas on 21/09/16.
 */
@Component
public class FacebookCallService {

    public Customer authenticate(String token){

        Facebook facebook = new FacebookFactory().getInstance();
        facebook.setOAuthAccessToken(new AccessToken(token));
        Reading reading = new Reading().fields("name,email");
        facebook4j.User facebookUser = null;
        try {
            facebookUser = facebook.getUser("me", reading);
            return new Customer(null, facebookUser.getFirstName(), facebookUser.getLastName(), null, facebookUser.getEmail(), null, null, token, null);

        } catch (FacebookException e) {
            e.printStackTrace();
            return null;
        }
    }
}
