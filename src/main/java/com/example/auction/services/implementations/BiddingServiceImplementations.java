package com.example.auction.services.implementations;

import com.example.auction.model.Bidding;
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
    public Optional<Bidding> getBiddingById(long id) {
        return biddingRepository.findById(id);
    }

    @Override
    public Bidding createBidding(Bidding bidding) {
        return biddingRepository.save(bidding);
    }

    @Override
    public List<Bidding> getAllBidsByUser(long id) {
        return null;
    }

    @Override
    public List<Bidding> getAllBidsByAuction(long id) {
        return null;
    }

    @Override
    public boolean deleteTutorial(long id) {
        return false;
    }
}
