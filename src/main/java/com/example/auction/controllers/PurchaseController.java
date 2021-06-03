package com.example.auction.controllers;


import com.example.auction.model.Purchase;
import com.example.auction.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    /**
     * POST: <code>/purchase</code>
     *
     * @param purchase The purchase to persist in database
     * @return create purchase
     */
    @PostMapping
    public ResponseEntity<Purchase> createPurchase(@RequestBody Purchase purchase){
        Purchase newPurchase = purchaseService.save(purchase);
        return new ResponseEntity<>(newPurchase, HttpStatus.CREATED);
    }

    /**
     * GET: <code>/purchase/all</code>
     * @return all purchases
     */
    @RequestMapping("/all")
    public ResponseEntity<List<Purchase>> getAllPurchases(@RequestParam(required = false) String string){
        List<Purchase> purchases = purchaseService.findAll();
        if(purchases.isEmpty()){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(purchases,HttpStatus.OK);
    }

    /**
     * PUT: <code>/purchase/id</code>
     *
     * @param id    The id of the old purchase to replace
     * @param purchase The new purchase
     * @return updated purchase in database
     */
    @PutMapping("/{id}")
    public ResponseEntity<Purchase> updatePurchase(@PathVariable("id") Long id, @RequestBody Purchase purchase){
        Purchase newPurchase = purchaseService.update(id, purchase);
        if(newPurchase==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newPurchase,HttpStatus.OK);
    }

    /**
     * DELETE: <code>/purchase/id</code>
     *
     * @param id The id of the purchase to set inActive
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePurchase(@PathVariable("id") Long id){
        boolean success = purchaseService.delete(id);
        if (success){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * GET: <code>/purchase/id</code>
     *
     * @param id The id of purchase to get
     */
    @GetMapping("/{id}")
    public ResponseEntity<Purchase> getPurchaseById(@PathVariable("id") Long id){
        Optional<Purchase> purchase = purchaseService.findById(id);
        if(purchase.isPresent()){
            return new ResponseEntity<>(purchase.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
