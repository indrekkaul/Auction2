package com.example.auction.controllers;

import com.example.auction.model.Auction;
import com.example.auction.repositorys.AuctionRepository;
import com.example.auction.services.implementations.AuctionServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class AuctionController {

    AuctionRepository auctionRepository;
    AuctionServiceImplementation auctionServiceImplementation;

    @Autowired
    public AuctionController(AuctionRepository auctionRepository
            ,AuctionServiceImplementation auctionServiceImplementation) {
        this.auctionRepository = auctionRepository;
        this.auctionServiceImplementation = auctionServiceImplementation;
    }

    /**
     * GET: <code>auctions</code>
     * @return all auctions in database
     * @param title to lookup the database for - optional
     */
    @GetMapping("/auctions")
    public ResponseEntity<List<Auction>> getAllAuctions(@RequestParam(required = false) String title){
        List<Auction> auctions = auctionServiceImplementation.findByTitle(title);
        if (auctions.isEmpty()){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(auctions,HttpStatus.OK);
    }

    //List<Auction> getAllAuctions() {        return auctionRepository.findAll();    }

    /**
     * GET: <code>active auctions</code>
     * @return all active auctions in database
     * @param title and active to lookup the database for - optional
     */
    @GetMapping("/active_auctions")
    public ResponseEntity<List<Auction>> getAllActiveAuctions(@RequestParam(required = false) String title, boolean active){
        List<Auction> auctions = auctionServiceImplementation.findByTitleAndIsActive(title,true);
        if (auctions.isEmpty()){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(auctions,HttpStatus.OK);
    }

    @PutMapping("/registerAuction")
    public String showRegistrationFormNewAuction(Model model){

        return "register Auction";
    }



    @GetMapping ("/singleAuction")
    public Auction getAuction(Auction auction) {
        return auctionRepository.getOne(auction.getId());

    }

}
