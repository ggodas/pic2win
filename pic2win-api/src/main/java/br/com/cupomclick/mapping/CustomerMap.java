package br.com.cupomclick.mapping;

import br.com.cupomclick.model.customer.CustomerCreateDTO;
import br.com.cupomclick.domain.customer.Customer;
import org.modelmapper.PropertyMap;

/**
 * Created by georgegodas on 02/10/16.
 */
public class CustomerMap extends PropertyMap<CustomerCreateDTO, Customer> {
    protected void configure(){
        skip().setId(null);
    }
}
