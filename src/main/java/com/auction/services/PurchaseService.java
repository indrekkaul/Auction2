package com.auction.services;

import com.auction.model.Purchase;
import com.auction.model.UserAccount;

import java.util.List;
import java.util.Optional;

public interface PurchaseService {

    Purchase findOne(Long id);

    Optional<Purchase> findById(Long id);

    Purchase save(Purchase purchase);

    Purchase update(Long id, Purchase newPurchase);

    List<Purchase> findAll();

    List<Purchase> findAllBySeller (UserAccount seller);

    List<Purchase> findAllByBuyer (UserAccount buyer);

    boolean delete(Long id);

    void restore(Long id);
}
