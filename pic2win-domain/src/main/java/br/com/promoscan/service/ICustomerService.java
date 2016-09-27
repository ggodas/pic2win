package br.com.promoscan.service;

import br.com.promoscan.Customer;
import br.com.promoscan.exception.CustomerAlreadyExistsException;
import br.com.promoscan.exception.DocumentIdAlreadyExistsException;
import br.com.promoscan.exception.EmailAlreadyExistsException;

/**
 * Created by georgegodas on 26/09/16.
 */
public interface ICustomerService {
    void create(Customer newCustomer) throws CustomerAlreadyExistsException, DocumentIdAlreadyExistsException, EmailAlreadyExistsException;
}
