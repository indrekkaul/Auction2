package com.auction.repositorys;

import com.auction.model.Category;
import com.auction.model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {

    List<Auction> findByItemCategory(Category itemCategory);

    List<Auction> findByActive(boolean active);

    List<Auction> findByTitleContaining(String title);

    List<Auction> findAllByEndingAfterAndActive (LocalDate localDate, boolean active);



}
