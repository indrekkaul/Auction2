package com.example.auction.services.implementations;

import com.example.auction.model.Auction;
import com.example.auction.repositorys.AuctionRepository;
import com.example.auction.services.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuctionServiceImplementation implements AuctionService {

    AuctionRepository auctionRepository;

    @Autowired
    public AuctionServiceImplementation(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @Override
    public Optional<Auction> findOne(Long id) {
        return Optional.ofNullable(auctionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Auction not found!")));
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
    public List<Auction> findByActive(boolean active) {
        return auctionRepository.findByActive(true);
    }

    @Override
    public List<Auction> findByEndigIsGreaterTheCurrentDate() {
        return auctionRepository.findAllByEndingAfter(LocalDate.now());
    }

    @Override
    public Auction save(Auction auction) {

        return auctionRepository.saveAndFlush(auction);
    }

    @Override
    public Auction update(Long id, Auction newAuction) {
        Optional<Auction> oldAuction = findOne(id);
        if (oldAuction.isPresent()) {
            Auction tempAuction = oldAuction.get();
            tempAuction.setDescription(newAuction.getDescription());
            tempAuction.setBuyNowPrice(newAuction.getBuyNowPrice());
            tempAuction.setEnding(newAuction.getEnding());
            tempAuction.setItemCategory(newAuction.getItemCategory());
            tempAuction.setMinimumPrice(newAuction.getMinimumPrice());
            tempAuction.setTitle(newAuction.getTitle());

            return auctionRepository.save(tempAuction);
        }else {
            return null;
        }
    }

    @Override
    public Auction updateNumberOfBids(Long id) {
        Auction updateNumberOfBidsByOne = auctionRepository.getOne(id);
        updateNumberOfBidsByOne.setNumberOfBids(updateNumberOfBidsByOne.getNumberOfBids()+1);
        return save(updateNumberOfBidsByOne);

    }

    @Override
    public boolean delete(Long id) {
        Auction auctionDelete = auctionRepository.getOne(id);
        auctionDelete.setActive(false);
        save(auctionDelete);
        return true;

    }

    @Override
    public boolean promoteAuction(Long id) {
        Auction promoteAuction = auctionRepository.getOne(id);
        promoteAuction.setPromotedToPremium(true);
        save(promoteAuction);
        return true;
    }

    @Override
    public boolean demoteAuction(Long id) {
        Auction demoteAuction = auctionRepository.getOne(id);
        demoteAuction.setPromotedToPremium(false);
        save(demoteAuction);
        return true;
    }

    @Override
    public void restore(Long id) {
        Auction auctionRestore = auctionRepository.getOne(id);
        auctionRestore.setActive(true);
        save(auctionRestore);
    }
}
