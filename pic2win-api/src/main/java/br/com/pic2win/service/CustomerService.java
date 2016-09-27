package br.com.pic2win.service;

import br.com.pic2win.Customer;
import br.com.pic2win.exception.CustomerAlreadyExistsException;
import br.com.pic2win.exception.DocumentIdAlreadyExistsException;
import br.com.pic2win.exception.EmailAlreadyExistsException;
import br.com.pic2win.repository.CustomerRepository;
import br.com.pic2win.validator.CustomerValidator;
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
