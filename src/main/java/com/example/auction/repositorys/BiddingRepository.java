package com.example.auction.repositorys;

import com.example.auction.model.Auction;
import com.example.auction.model.Bidding;
import com.example.auction.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BiddingRepository extends JpaRepository<Bidding, Long>{

    List<Bidding> findAllByUserAndActive(UserAccount userAccount, boolean active);

    List<Bidding> findByActive(boolean active);

    List<Bidding> findByAuctionAndActive(Auction auction, boolean active);

    Auction findBiddingByAuction(Long id);



}
