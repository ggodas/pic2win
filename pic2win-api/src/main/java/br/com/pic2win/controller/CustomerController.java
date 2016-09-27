package br.com.pic2win.controller;

import br.com.pic2win.Customer;
import br.com.pic2win.model.customer.CustomerCreateDTO;
import br.com.pic2win.model.customer.CustomerDTO;
import br.com.pic2win.model.validator.CustomerCreateValidator;
import br.com.pic2win.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.ExecutionException;

/**
 * Created by georgegodas on 01/09/16.
 */
@RestController
public class CustomerController {
    private CustomerRepository customerRepository;
    private CustomerCreateValidator customerCreateValidator;


    @Autowired
    public CustomerController(CustomerRepository customerRepository, CustomerCreateValidator customerCreateValidator) {
        this.customerRepository = customerRepository;
        this.customerCreateValidator = customerCreateValidator;
    }

    @RequestMapping(value = "/api/customer",method = RequestMethod.GET)
    public ResponseEntity<?> getOne()throws ExecutionException, InterruptedException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Customer customer = (Customer) auth.getPrincipal();

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/customer",method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody @Valid CustomerCreateDTO customerCreateDTO)throws ExecutionException, InterruptedException {
        ModelMapper modelMapper = new ModelMapper();

        Customer customer = customerRepository.findOneByEmailOrDocumentId(customerCreateDTO.getEmail(), customerCreateDTO.getDocumentId());

        if(customer != null)
            return new ResponseEntity<>(HttpStatus.CONFLICT);


        customer = modelMapper.map(customerCreateDTO, Customer.class);
        customerRepository.save(customer);

        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);

        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/customer",method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody @Valid CustomerCreateDTO customerCreateDTO)throws ExecutionException, InterruptedException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Customer customer = (Customer) auth.getPrincipal();

        ModelMapper modelMapper = new ModelMapper();

        customer = modelMapper.map(customerCreateDTO, Customer.class);

        customerRepository.save(customer);

        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);

        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }


    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setValidator(customerCreateValidator);
    }
}
