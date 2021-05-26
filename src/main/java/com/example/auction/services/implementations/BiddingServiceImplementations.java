package com.example.auction.services.implementations;

import com.example.auction.model.Auction;
import com.example.auction.model.Bidding;
import com.example.auction.model.UserAccount;
import com.example.auction.repositorys.AuctionRepository;
import com.example.auction.repositorys.BiddingRepository;
import com.example.auction.services.BiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BiddingServiceImplementations implements BiddingService {


    private final BiddingRepository biddingRepository;
    private final AuctionRepository auctionRepository;

    @Autowired
    public BiddingServiceImplementations(BiddingRepository biddingRepository, AuctionRepository auctionRepository) {
        this.biddingRepository = biddingRepository;
        this.auctionRepository = auctionRepository;
    }

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
    public List<Bidding> findAll() {
        return null;
    }

    @Override
    public Bidding save(Bidding bidding) {

         biddingRepository.saveAndFlush(bidding);
         Auction addNumberOfBidsToAuction = bidding.getAuction();
         addNumberOfBidsToAuction.setNumberOfBids(addNumberOfBidsToAuction.getNumberOfBids()+1);
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
            Auction addNumberOfBidsToAuction = newBid.getAuction();
            addNumberOfBidsToAuction.setNumberOfBids(addNumberOfBidsToAuction.getNumberOfBids()+1);
            return save(tempBid);
        } else {
            return null;
        }

    }


}



