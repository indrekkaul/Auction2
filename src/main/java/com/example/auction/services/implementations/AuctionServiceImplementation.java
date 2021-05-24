package com.example.auction.services.implementations;

import com.example.auction.model.Auction;
import com.example.auction.repositorys.AuctionRepository;
import com.example.auction.services.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuctionServiceImplementation implements AuctionService {

    AuctionRepository auctionRepository;

    @Autowired
    public AuctionServiceImplementation(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @Override
    public Auction findOne(Long id) {
        return auctionRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Auction not found!"));
    }

    @Override
    public List<Auction> findAll() {
        List<Auction> auctions = new ArrayList<>(auctionRepository.findAll());
        return auctions;
    }

    @Override
    public List<Auction> findByTitle(String title) {
        if (title == null){
            return auctionRepository.findAll();
        }else {
            return auctionRepository.findByTitleContaining(title);
        }

    }

    @Override
    public List<Auction> findByTitleAndIsActive(String title, boolean active) {
        return auctionRepository.findByTitleContainingAndActive(title,true);
    }

    @Override
    public void save(Auction auction) {
        auctionRepository.saveAndFlush(auction);
    }

    @Override
    public void update(Long id, Auction auction) {
        Auction oldAuction = findOne(auction.getId());
        oldAuction.setDescription(auction.getDescription());
        oldAuction.setBuyNowPrice(auction.getBuyNowPrice());
        oldAuction.setEnding(auction.getEnding());
        oldAuction.setItemCategory(auction.getItemCategory());
        oldAuction.setMinimumPrice(auction.getMinimumPrice());
        //oldAuction.setPromotedToPremium(auction.get);
        oldAuction.setTitle(auction.getTitle());

        save(oldAuction);
    }

    @Override
    public void delete(Long id) {
        Auction auctionDelete = findOne(id);
        auctionDelete.setActive(false);
        save(auctionDelete);

    }

    @Override
    public void restore(Long id) {
        Auction auctionRestore = findOne(id);
        auctionRestore.setActive(true);
        save(auctionRestore);
    }
}
