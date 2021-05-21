package com.example.auction.services.implementations;

import com.example.auction.model.Bidding;
import com.example.auction.repositorys.AuctionRepository;
import com.example.auction.repositorys.BiddingRepository;
import com.example.auction.services.BiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Bidding findOne(Long id) {
        return biddingRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User Bids not found!"));
    }

    @Override
    public void save(Bidding bidding) {

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
        //Auction oldNumberOfBids = find
        //oldNumberOfBids;                      NB!DOES NOT UPDATE Auction table numberOfBids field!!

        save(oldBid);
    }


}



