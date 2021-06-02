package com.example.auction.controllers;

import com.example.auction.model.Auction;
import com.example.auction.services.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/auction")
public class AuctionController {

    @Autowired
    private AuctionService auctionService;


    /**
     * POST: <code>/auction</code>
     *
     * @param auction The Auction to persist in database
     * @return created auction
     */
    @PostMapping
    public ResponseEntity<Auction> createAuction(@RequestBody Auction auction) {
        Auction newAuction = auctionService.save(auction);
        return new ResponseEntity<>(newAuction, HttpStatus.CREATED);
    }

    /**
     * GET: <code>/auction</code>
     * @return all auctions
     *
     */
    @GetMapping("/all")
    public ResponseEntity<List<Auction>> getAllAuctions(@RequestParam(required = false) String title){
        List<Auction> auctions = auctionService.findAll();
        if (auctions.isEmpty()){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(auctions,HttpStatus.OK);
    }



    /**
     * GET: <code>/auctions/active</code>
     * @return all active(NB! ending date is not passed) auctions in database
     *
     */
    @GetMapping("/active")
    public ResponseEntity<List<Auction>> getAllActiveAuctions(){
        List<Auction> auctions = auctionService.findByActive(true);
        if (auctions.isEmpty()){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(auctions,HttpStatus.OK);
    }

    /**
     * GET: <code>/auctions/title</code>
     * @return all auctions by title containing
     *
     */
    @GetMapping("/{title}")
    public ResponseEntity<List<Auction>> getAllByTitleContaining(@PathVariable("title") String title){
        List<Auction> auctions = auctionService.findAllByTitleContaining(title);

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
    @PutMapping("/{id}")
    public ResponseEntity<Auction> updateAuction(@PathVariable("id") Long id, @RequestBody Auction auction){
       Auction newAuction = auctionService.update(id,auction);
        if (newAuction == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newAuction,HttpStatus.OK);
    }

    /**
     * DELETE: <code>/auction/id</code>
     *
     * @param id The id of the auction to set inActive
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAuction(@PathVariable("id") Long id){
        boolean success = auctionService.delete(id);
        if (success){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
