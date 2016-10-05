package br.com.cupomclick.service;

import br.com.cupomclick.domain.customer.Customer;
import br.com.cupomclick.exception.CustomerAlreadyExistsException;
import br.com.cupomclick.exception.DocumentIdAlreadyExistsException;
import br.com.cupomclick.exception.EmailAlreadyExistsException;

/**
 * Created by georgegodas on 26/09/16.
 */
public interface ICustomerService {
    void create(Customer newCustomer) throws CustomerAlreadyExistsException, DocumentIdAlreadyExistsException, EmailAlreadyExistsException;
}
