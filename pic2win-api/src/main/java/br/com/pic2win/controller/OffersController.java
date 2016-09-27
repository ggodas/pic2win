package br.com.pic2win.controller;

import br.com.pic2win.model.OfferDTO;
import br.com.pic2win.Offer;
import br.com.pic2win.repository.OfferRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by georgegodas on 24/08/16.
 */
@RestController
public class OffersController {

    private OfferRepository offerRepository;

    @Autowired
    public OffersController(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @RequestMapping(value = "/api/offers",method = RequestMethod.GET)
    public ResponseEntity<?> getOffers() throws ExecutionException, InterruptedException {

        List<Offer> offerList = (List<Offer>) offerRepository.findAll();

        ModelMapper modelMapper = new ModelMapper();
        OfferDTO offerDTO = modelMapper.map(offerList.get(0), OfferDTO.class);

        return new ResponseEntity<>(offerDTO, HttpStatus.OK);
    }
}
