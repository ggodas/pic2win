package br.com.pic2win.repository;

import br.com.pic2win.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by georgegodas on 01/09/16.
 */
public interface CustomerRepository extends PagingAndSortingRepository<Customer, String> {

    Customer findOneByEmail(String email);
    Customer findOneByEmailAndPassword(String email, String password);
    Customer findOneByDocumentIdAndPassword(String documentId, String password);
    Customer findOneByFacebookToken(String facebookToken);
    Customer findOneByDocumentId(String documentId);
    Customer findOneByEmailOrDocumentId(String email, String documentId);
}