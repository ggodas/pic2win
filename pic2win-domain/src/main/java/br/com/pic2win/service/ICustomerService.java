package br.com.pic2win.service;

import br.com.pic2win.Customer;
import br.com.pic2win.exception.CustomerAlreadyExistsException;
import br.com.pic2win.exception.DocumentIdAlreadyExistsException;
import br.com.pic2win.exception.EmailAlreadyExistsException;

/**
 * Created by georgegodas on 26/09/16.
 */
public interface ICustomerService {
    void create(Customer newCustomer) throws CustomerAlreadyExistsException, DocumentIdAlreadyExistsException, EmailAlreadyExistsException;
}
