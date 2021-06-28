package com.auction.services;


import com.auction.model.Auction;
import com.auction.model.Bidding;
import com.auction.model.UserAccount;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface BiddingService {


    Optional<Bidding> findOne(Long id);

    List<Bidding> findByUserAndActive (UserAccount userAccount, boolean active);

    List<Bidding> findBidsByAuction(Auction auction);

    Bidding getNumberOfBidsForAuction(Auction auction);

    List<Bidding> findAll();

    Bidding save(Bidding bidding);

    Bidding update(Long id, Bidding newBid);

    BigDecimal getBestBid(Auction auction);

    Bidding getBestBidding(Auction auction);

    boolean delete(Long id);

    void restore(Long id);





}
