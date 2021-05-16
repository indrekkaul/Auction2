package com.example.auction.repositorys;

import com.example.auction.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {
}
