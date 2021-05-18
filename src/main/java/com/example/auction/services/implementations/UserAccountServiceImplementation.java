package com.example.auction.services.implementations;

import com.example.auction.model.Auction;
import com.example.auction.model.Bidding;
import com.example.auction.model.UserAccount;
import com.example.auction.repositorys.AddressRepository;
import com.example.auction.repositorys.AuctionRepository;
import com.example.auction.repositorys.BiddingRepository;
import com.example.auction.repositorys.UserAccountRepository;
import com.example.auction.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserAccountServiceImplementation  implements UserAccountService {

    UserAccountRepository userAccountRepository;
    AuctionRepository auctionRepository;
    AddressRepository addressRepository;
    BiddingRepository biddingRepository;


    @Autowired
    public UserAccountServiceImplementation(UserAccountRepository userAccountRepository,
                                            AuctionRepository auctionRepository,
                                            AddressRepository addressRepository,
                                            BiddingRepository biddingRepository) {
        this.userAccountRepository = userAccountRepository;
        this.auctionRepository = auctionRepository;
        this.addressRepository = addressRepository;
        this.biddingRepository = biddingRepository;

    }

    @Override
    public UserAccount findOne(Long id) {
        return userAccountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found!"));
    }

    @Override
    public void save(UserAccount userAccount) {
        userAccountRepository.saveAndFlush(userAccount);
    }

    @Override
    public void update(Long id, UserAccount userAccount) {
        UserAccount oldUser = findOne(userAccount.getId());
        oldUser.setAccountName(userAccount.getAccountName());
        oldUser.setAccountStatus(userAccount.getAccountStatus());
        oldUser.setAccountType(userAccount.getAccountType());
        oldUser.setAddress(userAccount.getAddress());
        oldUser.setEmail(userAccount.getEmail());

        save(oldUser);
    }

    @Override
    public void delete(Long id) {
        UserAccount deleteUser = findOne(id);
        deleteUser.setActive(false);
        save(deleteUser);

    }

    @Override
    public void restore(Long id) {
        UserAccount setActive = findOne(id);
        setActive.setActive(true);
        save(setActive);
    }

    @Override
    public List<Bidding> findAllUserBids(Long id, Bidding bidding) {
        //List<Bidding> bidding = biddingRepository
        //        .findAllById(Iterable<id>, List<Bidding>);
        //UserAccount findUserId = findOne(id);
        //List<Bidding> findAllUserBids = bidding.str

        return null;
    }

    @Override
    public List<Bidding> findAllActiveUserBids(Long id, UserAccount userAccount, Bidding bidding) {
        return null;
    }

    @Override
    public List<Auction> findAllUserAuctions(Long id, UserAccount userAccount, Auction auction) {
        return null;
    }

    @Override
    public List<Auction> findAllActiveUserAuctions(Long id, UserAccount userAccount, Auction auction) {
        return null;
    }
}
