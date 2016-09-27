package br.com.promoscan.repository;

import br.com.promoscan.Offer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by georgegodas on 24/08/16.
 */
@Repository("offer")
public interface OfferRepository extends PagingAndSortingRepository<Offer, String> {

}
