package br.com.pic2win.service;

import br.com.pic2win.Customer;
import org.springframework.stereotype.Service;

/**
 * Created by georgegodas on 01/09/16.
 */
@Service
public interface IAuthenticationService {
    Customer authenticate(String token);
}
