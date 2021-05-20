package com.example.auction.services.implementations;

import com.example.auction.model.Auction;
import com.example.auction.model.Bidding;
import com.example.auction.model.UserAccount;
import com.example.auction.repositorys.BiddingRepository;
import com.example.auction.repositorys.UserAccountRepository;
import com.example.auction.services.BiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BiddingServiceImplementations implements BiddingService {


    private final BiddingRepository biddingRepository;


    @Autowired
    public BiddingServiceImplementations(BiddingRepository biddingRepository) {
        this.biddingRepository = biddingRepository;
    }


    @Override
    public Bidding findOne(Long id) {
        return biddingRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User Bids not found!"));
    }

    @Override
    public void save(Bidding bidding) {
        bidding.setNumberOfBidsForCurrentAuction(1);
        biddingRepository.saveAndFlush(bidding);
    }

    @Override
    public void delete(Long id) {
        Bidding biddingDelete = findOne(id);
        biddingDelete.setActive(false);
        save(biddingDelete);
    }

    @Override
    public void restore(Long id) {
        Bidding setActive = findOne(id);
        setActive.setActive(true);
        save(setActive);

    }

    @Override
    public void update(Long id, Bidding bidding) {
        Bidding oldBid = findOne(bidding.getId());
        oldBid.setPrice(bidding.getPrice());
        oldBid.setNumberOfBidsForCurrentAuction(+1);

        save(oldBid);
    }


}



