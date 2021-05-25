package com.example.auction.controllers;

import com.example.auction.model.Auction;
import com.example.auction.services.implementations.AuctionServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class AuctionController {


    AuctionServiceImplementation auctionServiceImplementation;

    @Autowired
    public AuctionController(AuctionServiceImplementation auctionServiceImplementation) {
        this.auctionServiceImplementation = auctionServiceImplementation;
    }

    /**
     * POST: <code>/new_auction</code>
     *
     * @param auction The Auction to persist in database
     * @return created auction
     */
    @PostMapping("/new_auction")
    public ResponseEntity<Auction> createAuction(@RequestBody Auction auction) {
        Auction newAuction = auctionServiceImplementation.save(auction);
        return new ResponseEntity<>(newAuction, HttpStatus.CREATED);
    }

    /**
     * GET: <code>/auctions</code>
     * @return all auctions in database
     * @param title to lookup the database for - optional
     */
    @GetMapping("/auctions")
    public ResponseEntity<List<Auction>> getAllAuctions(@RequestParam(required = false) String title){
        List<Auction> auctions = auctionServiceImplementation.findByTitle(title);
        if (auctions.isEmpty()){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(auctions,HttpStatus.OK);
    }



    /**
     * GET: <code>/active_auctions</code>
     * @return all active auctions in database
     * @param active & active to lookup the database for - optional
     */
    @GetMapping("/active_auctions")
    public ResponseEntity<List<Auction>> getAllActiveAuctions(@RequestParam(required = false) boolean active){
        List<Auction> auctions = auctionServiceImplementation.findByActive(true);
        if (auctions.isEmpty()){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(auctions,HttpStatus.OK);
    }


    /**
     * PUT: <code>/auction/id</code>
     *
     * @param id        The id of the old auction to replace
     * @param auction   The new auction
     * @return updated auction in database
     */
    @PutMapping("/auction/{id}")
    public ResponseEntity<Auction> updateAuction(@PathVariable("id") Long id, @RequestBody Auction auction){
       Auction newAuction = auctionServiceImplementation.update(id,auction);
        if (newAuction == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newAuction,HttpStatus.OK);
    }

    /**
     * DELETE: <code>/auction/id</code>
     *
     * @param id The id of the auction to set in Active
     */

    @DeleteMapping("/auction/{id}")
    public ResponseEntity<HttpStatus> deleteAuction(@PathVariable("id") Long id){
        boolean success = auctionServiceImplementation.delete(id);
        if (success){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
