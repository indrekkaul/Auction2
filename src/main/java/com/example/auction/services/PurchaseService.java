package com.example.auction.services;

import com.example.auction.model.Purchase;

public interface PurchaseService {

    Purchase findOne(Long id);

    void save(Purchase purchase);

    void update(Long id, Purchase purchase);

    void delete(Long id);

    void restore(Long id);
}
