package com.example.auction.services;

import com.example.auction.model.Auction;
import com.example.auction.model.Bidding;
import com.example.auction.model.UserAccount;
import org.graalvm.compiler.lir.alloc.lsra.LinearScan;

import java.util.List;

public interface UserAccountService {
    UserAccount findOne(Long id);

    void save(UserAccount userAccount);

    void update (Long id, UserAccount userAccount);

    void delete(Long id);

    void restore(Long id);

    List<Bidding> findAllUserBids (Long id, UserAccount userAccount, Bidding bidding);

    List<Bidding> findAllActiveUserBids (Long id, UserAccount userAccount, Bidding bidding);

    List<Auction> findAllUserAuctions(Long id, UserAccount userAccount, Auction auction);

    List<Auction> findAllActiveUserAuctions(Long id, UserAccount userAccount, Auction auction);


}
