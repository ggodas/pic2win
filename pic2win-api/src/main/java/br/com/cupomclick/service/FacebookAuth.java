package br.com.cupomclick.service;

import br.com.cupomclick.domain.customer.Customer;
import br.com.cupomclick.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by georgegodas on 01/09/16.
 */
@Component("FacebookAuth")
public class FacebookAuth implements IAuthenticationService {
    private CustomerRepository customerRepository;
    private FacebookCallService facebookCallService;

    @Autowired
    public FacebookAuth(CustomerRepository customerRepository, FacebookCallService facebookCallService) {
        this.customerRepository = customerRepository;
        this.facebookCallService = facebookCallService;
    }

    @Override
    public Customer authenticate(String token) {

        Customer customer = customerRepository.findOneByFacebookToken(token);

        if(customer != null)
            return customer;

        customer = facebookCallService.authenticate(token);

        return customerRepository.findOneByEmail(customer.getEmail());
    }
}
