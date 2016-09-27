package br.com.promoscan.service;

import br.com.promoscan.Customer;
import org.springframework.stereotype.Service;

/**
 * Created by georgegodas on 01/09/16.
 */
@Service
public interface IAuthenticationService {
    Customer authenticate(String token);
}
