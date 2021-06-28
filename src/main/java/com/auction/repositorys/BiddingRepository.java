package com.auction.repositorys;

import com.auction.model.UserAccount;
import com.auction.model.Auction;
import com.auction.model.Bidding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BiddingRepository extends JpaRepository<Bidding, Long>{

    List<Bidding> findAllByUserAndActive(UserAccount userAccount, boolean active);

    List<Bidding> findByActive(boolean active);

    List<Bidding> findByAuctionAndActive(Auction auction, boolean active);

    List<Bidding> findBiddingsByAuction(Auction auction);

    Bidding countBiddingsByAuction(Auction auction);



}
