package com.example.auction.repositorys;

import com.example.auction.model.Auction;
import com.example.auction.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {

    List<Auction> findByItemCategory(Category itemCategory);

    List<Auction> findByActive(boolean active);

    List<Auction> findByTitleContainingAndActive(String title, boolean active);

    List<Auction> findByTitleContaining(String title);


}
