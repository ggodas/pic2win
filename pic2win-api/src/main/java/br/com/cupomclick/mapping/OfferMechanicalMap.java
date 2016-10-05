package br.com.cupomclick.mapping;

import br.com.cupomclick.domain.offer.mechanic.OfferFoodMechanic;
import br.com.cupomclick.model.offer.OfferFoodCreateFoodMachanicalofferDTO;
import org.modelmapper.PropertyMap;

/**
 * Created by georgegodas on 03/10/16.
 */
public class OfferMechanicalMap extends PropertyMap<OfferFoodCreateFoodMachanicalofferDTO, OfferFoodMechanic> {
    protected void configure(){

        map().setParticipationsNeededToWin(10);
    }
}