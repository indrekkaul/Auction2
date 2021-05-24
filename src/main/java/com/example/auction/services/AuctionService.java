package com.example.auction.services;

import com.example.auction.model.Auction;

import java.util.List;

public interface AuctionService {

    Auction findOne(Long id);

    List<Auction> findAll();

    List<Auction> findByTitle(String title);

    List<Auction> findByTitleAndIsActive(String title, boolean active);

    void save (Auction auction);

    void update(Long id, Auction auction);

    void delete (Long id);

    void restore (Long id);
}
