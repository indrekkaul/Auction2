package com.example.auction.services.implementations;

import com.example.auction.model.UserAccount;
import com.example.auction.repositorys.UserAccountRepository;
import com.example.auction.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImplementation  implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public UserAccount findOne(Long id) {
        return userAccountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found!"));
    }

    @Override
    public Optional<UserAccount> findById(Long id) {
        return Optional.ofNullable(userAccountRepository.findById(id))
                .orElseThrow(()-> new RuntimeException(("User not found!")));
    }

    @Override
    public List<UserAccount> findAll() {
        List<UserAccount> findAll = userAccountRepository.findAll();
        return findAll;
    }

    @Override
    public UserAccount save(UserAccount userAccount)  {
        return userAccountRepository.saveAndFlush(userAccount);
    }

    @Override
    public UserAccount update(Long id, UserAccount newUserAccount) {
        Optional<UserAccount> oldUser = Optional.ofNullable(findOne(id));
        if(oldUser.isPresent()){
            UserAccount tempUser = oldUser.get();
            tempUser.setAccountStatus(newUserAccount.getAccountStatus());
            tempUser.setAccountType(newUserAccount.getAccountType());
            tempUser.setAccountName(newUserAccount.getAccountName());
            tempUser.setAddress(newUserAccount.getAddress());
            tempUser.setEmail(newUserAccount.getEmail());
            tempUser.setPassword(newUserAccount.getPassword());
            return save(tempUser);
        }
        throw new RuntimeException("Cant update record does not exists in database!");
    }

    @Override
    public boolean delete(Long id) {
        UserAccount deleteUser = findOne(id);
        deleteUser.setActive(false);
        save(deleteUser);
        return true;
    }

    @Override
    public void restore(Long id) {
        UserAccount setActive = findOne(id);
        setActive.setActive(true);
        save(setActive);
    }


}
