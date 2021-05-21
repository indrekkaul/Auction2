package com.example.auction.services.implementations;

import com.example.auction.model.UserAccount;
import com.example.auction.repositorys.UserAccountRepository;
import com.example.auction.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImplementation  implements UserAccountService {

    UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountServiceImplementation(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;



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


}
