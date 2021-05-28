package com.example.auction.services;

import com.example.auction.model.Auction;

import java.util.List;
import java.util.Optional;

public interface AuctionService {

    Optional<Auction> findOne(Long id);

    List<Auction> findAll();

    List<Auction> findByActive(boolean active);

    List<Auction> findByEndigIsGreaterTheCurrentDate();

    Auction save (Auction auction);

    Auction update(Long id, Auction newAuction);

    boolean delete (Long id);

    boolean promoteAuction (Long id);

    boolean demoteAuction (Long id);

    void restore (Long id);
}
