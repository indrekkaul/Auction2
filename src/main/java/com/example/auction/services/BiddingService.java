package com.example.auction.services;


import com.example.auction.model.Auction;
import com.example.auction.model.Bidding;
import com.example.auction.model.UserAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BiddingService {
    Bidding findOne(Long id);

    void save(Bidding bidding);

    void update(Long id, Bidding bidding);

    void delete(Long id);

    void restore(Long id);





}
