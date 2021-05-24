package com.example.auction.controllers;


import com.example.auction.model.Purchase;
import com.example.auction.repositorys.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PurchaseController {

    PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @GetMapping("/getPurchase")
    public String getPurchase(){
        return "getPurchase";
    }

    @GetMapping("/allPurchases")
    List<Purchase> getAllPurchases(){
        return purchaseRepository.findAll();
    }



}
