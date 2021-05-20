package com.example.auction.services;

import com.example.auction.model.UserAccount;

public interface UserAccountService {
    UserAccount findOne(Long id);

    void save(UserAccount userAccount);

    void update (Long id, UserAccount userAccount);

    void delete(Long id);

    void restore(Long id);



}
