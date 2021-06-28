package com.auction.repositorys;

import com.auction.model.Purchase;
import com.auction.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    List<Purchase> findAllBySeller (UserAccount seller);

    List<Purchase> findAllByBuyer (UserAccount buyer);

}
