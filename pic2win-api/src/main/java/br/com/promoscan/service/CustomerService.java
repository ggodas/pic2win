package br.com.promoscan.service;

import br.com.promoscan.Customer;
import br.com.promoscan.exception.CustomerAlreadyExistsException;
import br.com.promoscan.exception.DocumentIdAlreadyExistsException;
import br.com.promoscan.exception.EmailAlreadyExistsException;
import br.com.promoscan.repository.CustomerRepository;
import br.com.promoscan.validator.CustomerValidator;
import org.springframework.stereotype.Component;

/**
 * Created by georgegodas on 21/09/16.
 */
@Component
public class CustomerService implements ICustomerService {

    private FacebookCallService facebookCallService;
    private CustomerRepository customerRepository;
    private CustomerValidator customerValidator;

    @Override
    public void create(Customer newCustomer) throws CustomerAlreadyExistsException, DocumentIdAlreadyExistsException, EmailAlreadyExistsException {

        Customer customer = customerRepository.findOneByDocumentId(newCustomer.getDocumentId());
        if (customer != null) {
            throw new DocumentIdAlreadyExistsException("Document Id Already Exists");
        }

        customer = customerRepository.findOneByDocumentId(newCustomer.getDocumentId());
        if(customer != null) {
            throw new EmailAlreadyExistsException("Email already exists in database");
        }


    }
}
