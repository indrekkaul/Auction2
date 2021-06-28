package com.auction.repositorys;

import com.auction.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{

    List<UserAccount> findAllByActive(UserAccount account);

    List<UserAccount> getAllByAccountName(UserAccount account);
}
