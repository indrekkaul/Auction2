package com.example.auction.repositorys;

import com.example.auction.model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
    List<Auction> findByCategoryContaining(String category);
}
