package com.auction.services;

import com.auction.model.UserAccount;

import java.util.List;
import java.util.Optional;

public interface UserAccountService {

    UserAccount findOne(Long id);

    Optional<UserAccount> findById(Long id);

    List<UserAccount> findAll();

    UserAccount save(UserAccount userAccount);

    UserAccount update (Long id, UserAccount newUserAccount);

    boolean delete(Long id);

    void restore(Long id);



}
