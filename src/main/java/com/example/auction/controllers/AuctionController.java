package com.example.auction.controllers;

import com.example.auction.model.Auction;
import com.example.auction.repositorys.AuctionRepository;
import com.example.auction.services.implementations.AuctionServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PutMapping("/registerAuction")
    public String showRegistrationFormNewAuction(Model model){

        return "register Auction";
    }

    @GetMapping("/allAuctions")
    List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }

    @GetMapping ("/singleAuction")
    public Auction getAuction(Auction auction) {
        return auctionRepository.getOne(auction.getId());

    }

}
