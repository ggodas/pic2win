package br.com.cupomclick.service;

import br.com.cupomclick.domain.customer.Customer;
import org.springframework.stereotype.Service;

/**
 * Created by georgegodas on 01/09/16.
 */
@Service
public interface IAuthenticationService {
    Customer authenticate(String token);
}
