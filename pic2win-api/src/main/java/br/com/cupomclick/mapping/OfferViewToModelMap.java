package br.com.cupomclick.mapping;

import br.com.cupomclick.model.offer.OfferFoodCreateDTO;
import br.com.cupomclick.domain.offer.Offer;
import br.com.cupomclick.domain.offer.mechanic.OfferFoodMechanic;
import org.modelmapper.PropertyMap;

/**
 * Created by georgegodas on 03/10/16.
 */
public class OfferViewToModelMap extends PropertyMap<OfferFoodCreateDTO, Offer> {


    protected void configure(){

        OfferFoodMechanic offerFoodMechanic = new OfferFoodMechanic();
        map().setOfferMechanic(offerFoodMechanic);
//        map(source.getAmountMinToParticipate()).set;
        skip().setId(null);
    }
}