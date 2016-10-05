package br.com.cupomclick.repository;

import br.com.cupomclick.domain.customer.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

/**
 * Created by georgegodas on 01/09/16.
 */
@Component
public interface CustomerRepository extends PagingAndSortingRepository<Customer, String> {

    Customer findOneByEmail(String email);
    Customer findOneByEmailAndPassword(String email, String password);
    Customer findOneByDocumentIdAndPassword(String documentId, String password);
    Customer findOneByFacebookToken(String facebookToken);
    Customer findOneByDocumentId(String documentId);
    Customer findOneByEmailOrDocumentId(String email, String documentId);
}