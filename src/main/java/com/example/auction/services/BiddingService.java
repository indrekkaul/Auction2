package com.example.auction.services;


import com.example.auction.model.Auction;
import com.example.auction.model.Bidding;
import com.example.auction.model.UserAccount;

import java.util.List;
import java.util.Optional;

public interface BiddingService {
    Bidding findOne(Long id);

    void save(Bidding bidding);

    void update(Long id, Bidding bidding);

    void delete(Long id);

    void restore(Long id);

    Optional<Bidding> getBiddingById (long id);

    Bidding createBidding(Bidding bidding);

    List<Bidding> getAllBidsByUser (long id, UserAccount userAccount);

    List<Bidding> getAllBidsByAuction(long id, Auction auction);





}
