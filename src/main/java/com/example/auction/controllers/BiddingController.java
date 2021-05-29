package com.example.auction.controllers;

import com.example.auction.model.Bidding;
import com.example.auction.model.UserAccount;
import com.example.auction.services.BiddingService;
import com.example.auction.services.implementations.BiddingServiceImplementations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class BiddingController {

    @Autowired
    private BiddingService biddingService;

    /**
     * POST: <code>/new_bid</code>
     *
     * @param bidding The Bidding to persist in database
     * @return created bidding
     */
    @PostMapping("/new_bid")
    public ResponseEntity<Bidding> createBid(@RequestBody Bidding bidding) {
        Bidding newBidding = biddingService.save(bidding);
        return new ResponseEntity<>(newBidding, HttpStatus.CREATED);
    }

    /**
     * GET: <code>/user_bids</code>
     * @return all active user bids in database
     * @param userAccount active bids to lookup
     */

    @GetMapping("/user_bids")
    public ResponseEntity<List<Bidding>> getAllUserBids(@RequestParam(required = false) UserAccount userAccount, boolean active){
        List<Bidding> allUserActiveBids = biddingService.findByUserAndActive(userAccount,true);
        if (allUserActiveBids.isEmpty()){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allUserActiveBids,HttpStatus.OK);
    }

    /**
     * PUT: <code>/bidding/id</code>
     *
     * @param id        The id of the old bid to replace
     * @param bidding   The new bid
     * @return updated bidding in database
     */
    @PutMapping("/bidding/{id}")
    public ResponseEntity<Bidding> updateBidding(@PathVariable("id") Long id, @RequestBody Bidding bidding){
        Bidding newBid = biddingService.update(id,bidding);
        if (newBid == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newBid,HttpStatus.OK);
    }

}
