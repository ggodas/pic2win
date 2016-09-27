package br.com.promoscan.service;

import br.com.promoscan.Customer;
import br.com.promoscan.repository.CustomerRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

/**
 * Created by georgegodas on 01/09/16.
 */
@Component("PromoscanAuth")
public class PromoscanAuth implements IAuthenticationService {

    private CustomerRepository customerRepository;
    final String regex = "^[0-9]";

    @Autowired
    public PromoscanAuth(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer authenticate(String token) {

        String credentials = new String(Base64.decodeBase64(token), Charset.forName("UTF-8"));
        final String[] values = credentials.split(":", 2);
        String login = values[0];
        String password = values[1];

        if(login.matches(regex))
            return customerRepository.findOneByDocumentIdAndPassword(login, password);
        else
            return customerRepository.findOneByEmailAndPassword(login, password);
    }
}
