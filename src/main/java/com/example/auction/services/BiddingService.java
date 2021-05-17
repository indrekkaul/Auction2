package com.example.auction.services;


import com.example.auction.model.Bidding;
import com.example.auction.model.UserAccount;

import java.util.List;
import java.util.Optional;

public interface BiddingService {
    Optional<Bidding> getBiddingById (long id);

    Bidding createBidding(Bidding bidding);

    List<Bidding> getAllBidsByUser (long id);

    List<Bidding> getAllBidsByAuction(long id);

    boolean deleteTutorial(long id);



}
