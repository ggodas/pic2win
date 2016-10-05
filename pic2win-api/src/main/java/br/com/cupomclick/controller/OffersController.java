package br.com.cupomclick.controller;

import br.com.cupomclick.mapping.OfferMechanicalMap;
import br.com.cupomclick.model.offer.OfferFoodCreateDTO;
import br.com.cupomclick.domain.offer.Offer;
import br.com.cupomclick.mapping.OfferViewToModelMap;
import br.com.cupomclick.model.OfferDTO;
import br.com.cupomclick.repository.OfferRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by georgegodas on 24/08/16.
 */
@RestController
@RequestMapping(value = "/api/offers")
public class OffersController {

    private OfferRepository offerRepository;

    @Autowired
    public OffersController(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getOffers( @RequestHeader(value = "OS-Version", required = false) String osVersion,
                                        @RequestHeader(value = "Device-Model", required = false) String deviceModel,
                                        @RequestHeader(value = "Device-Token", required = false) String deviceToken)
            throws ExecutionException, InterruptedException {

        List<Offer> offerList = (List<Offer>) offerRepository.findAll();

        ModelMapper modelMapper = new ModelMapper();
        OfferDTO offerDTO = modelMapper.map(offerList.get(0), OfferDTO.class);

        return new ResponseEntity<>(offerDTO, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addOffer(@RequestBody OfferFoodCreateDTO offerFoodCreateDTO)
            throws ExecutionException, InterruptedException {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new OfferViewToModelMap());
        modelMapper.addMappings(new OfferMechanicalMap());
        Offer offer = modelMapper.map(offerFoodCreateDTO, Offer.class);


        offerRepository.save(offer);

        return new ResponseEntity<>(DayOfWeek.values(), HttpStatus.OK);

    }

}
