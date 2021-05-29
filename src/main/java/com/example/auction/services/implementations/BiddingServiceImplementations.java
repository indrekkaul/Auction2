package com.example.auction.services.implementations;

import com.example.auction.model.Auction;
import com.example.auction.model.Bidding;
import com.example.auction.model.UserAccount;
import com.example.auction.repositorys.AuctionRepository;
import com.example.auction.repositorys.BiddingRepository;
import com.example.auction.services.BiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class BiddingServiceImplementations implements BiddingService {

    @Autowired
    private  BiddingRepository biddingRepository;

    @Override
    public Optional<Bidding> findOne(Long id) {
        return biddingRepository.findById(id);
    }

    @Override
    public List<Bidding> findByUserAndActive(UserAccount userAccount, boolean active) {
        List<Bidding> findByUserAndActive = biddingRepository.findAllByUserAndActive(userAccount,true);
        return findByUserAndActive;
    }

    @Override
    public List<Bidding> findBidsByAuction(Long auction_id) {
        List<Bidding> bidsByAuction = biddingRepository.findBiddingsByAuction(auction_id);
        return bidsByAuction;
    }

    @Override
    public Bidding getNumberOfBidsForAuction(Long auction_id) {
        return biddingRepository.countBiddingsByAuction(auction_id);
    }

    @Override
    public List<Bidding> findAll() {
        return null;
    }

    @Override
    public Bidding save(Bidding bidding) {

         biddingRepository.saveAndFlush(bidding);
         Auction auction = bidding.getAuction();

         if (auction.getBuyNowPrice().compareTo(bidding.getPrice())==-1
                 | auction.getBuyNowPrice().compareTo(bidding.getPrice())==0){
            auction.setActive(false);
         }
         return null;
    }

    @Override
    public boolean delete(Long id) {
        Bidding biddingDelete = biddingRepository.getOne(id);
        biddingDelete.setActive(false);
        save(biddingDelete);
        return true;
    }

    @Override
    public void restore(Long id) {
        Bidding setActive = biddingRepository.getOne(id);
        setActive.setActive(true);
        save(setActive);

    }

    @Override
    public Bidding update(Long id, Bidding newBid) {
        Optional<Bidding> oldBid = findOne(id);
        if (oldBid.isPresent()){
            Bidding tempBid = oldBid.get();
            tempBid.setPrice(newBid.getPrice());
            return save(tempBid);
        } else {
            return null;
        }

    }

    @Override
    public Bidding getBestBid(Long auction_id) {
        Bidding winnerBid = Collections.max(findBidsByAuction(auction_id), Comparator.comparing(Bidding::getPrice));
        return winnerBid;
    }


}



