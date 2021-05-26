package com.example.auction.services;


import com.example.auction.model.Bidding;
import com.example.auction.model.UserAccount;
import java.util.List;
import java.util.Optional;

public interface BiddingService {


    Optional<Bidding> findOne(Long id);

    List<Bidding> findByUserAndActive (UserAccount userAccount, boolean active);

    List<Bidding> findAll();

    Bidding save(Bidding bidding);

    Bidding update(Long id, Bidding newBid);

    boolean delete(Long id);

    void restore(Long id);





}
