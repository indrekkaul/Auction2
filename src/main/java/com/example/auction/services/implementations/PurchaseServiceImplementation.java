package com.example.auction.services.implementations;

import com.example.auction.model.Purchase;
import com.example.auction.model.UserAccount;
import com.example.auction.repositorys.PurchaseRepository;
import com.example.auction.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseServiceImplementation  implements PurchaseService {

    @Autowired
    private  PurchaseRepository purchaseRepository;

    @Override
    public Purchase findOne(Long id) {
        return purchaseRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Purchase not found!"));
    }

    @Override
    public Optional<Purchase> findById(Long id) {
        return Optional.ofNullable(purchaseRepository.findById(id))
                .orElseThrow(()-> new RuntimeException("Purchase not found!"));
    }

    @Override
    public Purchase save(Purchase purchase) {
        return purchaseRepository.saveAndFlush(purchase);

    }

    @Override
    public Purchase update(Long id, Purchase newPurchase) {
        Optional<Purchase> oldPurchase = Optional.ofNullable(findOne(id));
        if(oldPurchase.isPresent()){
            Purchase tempPurchase = oldPurchase.get();
            tempPurchase.setBuyer(newPurchase.getBuyer());
            tempPurchase.setSeller(newPurchase.getSeller());
            tempPurchase.setAuction(newPurchase.getAuction());
            return save(tempPurchase);
        }else {
            throw new RuntimeException("Cant update record does not exists in database!");
        }
    }

    @Override
    public List<Purchase> findAll() {
        List<Purchase> purchases = new ArrayList<>(purchaseRepository.findAll());
        return purchases;
    }

    @Override
    public List<Purchase> findAllBySeller(UserAccount seller) {
        List<Purchase> findAllBySeller = purchaseRepository.findAllBySeller(seller);
        return findAllBySeller;
    }

    @Override
    public List<Purchase> findAllByBuyer(UserAccount buyer) {
        List<Purchase> findAllByBuyer = purchaseRepository.findAllByBuyer(buyer);
        return findAllByBuyer;
    }

    @Override
    public boolean delete(Long id) {
        Purchase purchaseDelete = findOne(id);
        purchaseDelete.setActive(false);
        save(purchaseDelete);
        return true;
    }

    @Override
    public void restore(Long id) {
        Purchase purchaseRestore = findOne(id);
        purchaseRestore.setActive(true);
        save(purchaseRestore);
    }
}
