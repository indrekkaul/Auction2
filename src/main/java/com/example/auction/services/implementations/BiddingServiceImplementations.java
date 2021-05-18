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
    private final UserAccountRepository userAccountRepository;

    @Autowired
    public BiddingServiceImplementations(BiddingRepository biddingRepository, UserAccountRepository userAccountRepository) {
        this.biddingRepository = biddingRepository;
        this.userAccountRepository = userAccountRepository;
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
    public Optional<Bidding> getBiddingById(long id) {
        return biddingRepository.findById(id);
    }

    @Override
    public Bidding createBidding(Bidding bidding) {
        return biddingRepository.save(bidding);
    }

    @Override
    public List<Bidding> getAllBidsByUser(long id, UserAccount userAccount) {

        return null;
    }

    @Override
    public List<Bidding> getAllBidsByAuction(long id, Auction auction) {
        //List<Bidding> AllBidsByAuction;
        return null;
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



