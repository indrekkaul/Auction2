package com.example.auction.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Purchase extends JpaRepository<Purchase, Long> {

}
