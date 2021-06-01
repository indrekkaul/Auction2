package com.example.auction.services.implementations;

import com.example.auction.model.Auction;
import com.example.auction.model.Bidding;
import com.example.auction.model.UserAccount;
import com.example.auction.repositorys.BiddingRepository;
import com.example.auction.services.BiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    public List<Bidding> findBidsByAuction(Auction auction) {
        List<Bidding> bidsByAuction = biddingRepository.findBiddingsByAuction(auction);
        return bidsByAuction;
    }

    @Override
    public Bidding getNumberOfBidsForAuction(Auction auction) {
        return biddingRepository.countBiddingsByAuction(auction);
    }

    @Override
    public List<Bidding> findAll() {
        return null;
    }

    @Override
    public Bidding save(Bidding bidding) {

        return biddingRepository.saveAndFlush(bidding);
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
    public BigDecimal getBestBid(Auction auction) {
        List<Bidding> biddingList = findBidsByAuction(auction);
        BigDecimal max = biddingList
                .stream()
                .map(a -> a.getPrice())
                .max(Comparator.naturalOrder())
                .orElse(BigDecimal.ZERO);
       return max;
    }

    @Override
    public Bidding getBestBidding(Auction auction) {
        List<Bidding> biddingList = findBidsByAuction(auction);
        Bidding maxBidding = biddingList
                .stream()
                .max(Comparator.comparing(p -> p.getPrice()))
                .get();
        return maxBidding;
    }


}



