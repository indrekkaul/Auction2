package com.example.auction.controllers;

import com.example.auction.model.Auction;
import com.example.auction.model.Bidding;
import com.example.auction.model.UserAccount;
import com.example.auction.services.AuctionService;
import com.example.auction.services.BiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/bid")
public class BiddingController {

    @Autowired
    private BiddingService biddingService;

    @Autowired
    private AuctionService auctionService;

    /**
     * POST: <code>/bid</code>
     *
     * @param bidding The Bidding to persist in database
     * @return created bidding
     */
    @PostMapping
    public ResponseEntity<Bidding> createBid(@RequestBody Bidding bidding) {
        Bidding newBidding = biddingService.save(bidding);
        return new ResponseEntity<>(newBidding, HttpStatus.CREATED);
/*        BigDecimal highestPrice = biddingService.getBestBid(bidding.getAuction());
        BigDecimal priceNow = bidding.getPrice();


        if (highestPrice.compareTo(priceNow)>0) {
            if (bidding.getAuction().getBuyNowPrice().compareTo(bidding.getPrice()) < 0
                    | bidding.getAuction().getBuyNowPrice().compareTo(bidding.getPrice()) == 0) {
                auctionService.delete(bidding.getAuction().getId());
            }
            //return new ResponseEntity<>(HttpStatus.valueOf("Invalid value"));
        } else {
            return new ResponseEntity<>(HttpStatus.valueOf("Invalid value"));

        }
        return new ResponseEntity<>(newBidding, HttpStatus.CREATED);*/
    }

    /**
     * GET:
     * @return all active user bids in database
     * @param auction active bids to lookup
     */

    @GetMapping("/auction/{id}")
    public ResponseEntity<List<Bidding>> getAllAuctionBids(@PathVariable("id") Auction auction){
        List<Bidding> allBidsByAuction = biddingService.findBidsByAuction(auction);
        if (allBidsByAuction.isEmpty()){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allBidsByAuction,HttpStatus.OK);
    }
    /**
     * GET:
     * @return all active user bids in database
     * @param auction best bid to lookup
     */

    @GetMapping("/best/{id}")
    public ResponseEntity<List<Bidding>> getBestAuctionBid(@PathVariable("id") Auction auction){
        Bidding getBestAuctionBid = biddingService.getBestBidding(auction);
        if (getBestAuctionBid == null){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(getBestAuctionBid,HttpStatus.OK);
    }

    /**
     * GET:
     * @return all active user bids in database
     * @param userAccount active bids to lookup
     */

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Bidding>> getAllUserBids(@PathVariable("id") UserAccount userAccount, boolean active){
        List<Bidding> allUserActiveBids = biddingService.findByUserAndActive(userAccount,true);
        if (allUserActiveBids.isEmpty()){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allUserActiveBids,HttpStatus.OK);
    }

    /**
     * PUT: <code>/bid/id</code>
     *
     * @param id        The id of the old bid to replace
     * @param bidding   The new bid
     * @return updated bidding in database
     */
    @PutMapping("{id}")
    public ResponseEntity<Bidding> updateBidding(@PathVariable("id") Long id, @RequestBody Bidding bidding){
        Bidding newBid = biddingService.update(id,bidding);
        if (newBid == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newBid,HttpStatus.OK);
    }

}
