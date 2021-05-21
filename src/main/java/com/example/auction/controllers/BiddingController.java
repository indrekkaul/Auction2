package com.example.auction.controllers;

import com.example.auction.model.Bidding;
import com.example.auction.repositorys.BiddingRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BiddingController {

    BiddingRepository biddingRepository;

    public BiddingController(BiddingRepository biddingRepository) {
        this.biddingRepository = biddingRepository;
    }

    @GetMapping("/registerNewBid")
    public String showRegistrationFormNewBid(Model model) {
        //model.addAttribute("Bid", new Bidding());

        return "register";

    }
    @RequestMapping("/bidding")
    List<Bidding> getBids(){
        return biddingRepository.findAll();
    }
}
