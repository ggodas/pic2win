package br.com.cupomclick.service;

import br.com.cupomclick.domain.customer.Customer;
import br.com.cupomclick.exception.CustomerAlreadyExistsException;
import br.com.cupomclick.exception.DocumentIdAlreadyExistsException;
import br.com.cupomclick.exception.EmailAlreadyExistsException;
import br.com.cupomclick.repository.CustomerRepository;
import br.com.cupomclick.validator.CustomerValidator;
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
