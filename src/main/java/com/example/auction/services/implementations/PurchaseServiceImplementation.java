package com.example.auction.services.implementations;

import com.example.auction.model.Purchase;
import com.example.auction.repositorys.PurchaseRepository;
import com.example.auction.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImplementation  implements PurchaseService {

    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseServiceImplementation(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }


    @Override
    public Purchase findOne(Long id) {
        return purchaseRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Purchase not found!"));
    }

    @Override
    public void save(Purchase purchase) {
        purchaseRepository.saveAndFlush(purchase);

    }

    @Override
    public void update(Long id, Purchase purchase) {
        Purchase purchaseOld = findOne(purchase.getId());
        purchaseOld.setFinalPrice(purchase.getFinalPrice());
        purchaseOld.setAuction(purchase.getAuction());
        purchaseOld.setSeller(purchase.getSeller());
        save(purchaseOld);
    }

    @Override
    public void delete(Long id) {
        Purchase purchaseDelete = findOne(id);
        purchaseDelete.setActive(false);
        save(purchaseDelete);
    }

    @Override
    public void restore(Long id) {
        Purchase purchaseRestore = findOne(id);
        purchaseRestore.setActive(true);
        save(purchaseRestore);
    }
}
