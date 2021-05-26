package com.example.auction.repositorys;

import com.example.auction.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAllByActive(boolean active);

    List<Address> findAllByCity(String city);

    List<Address> findAllByStreet(String street);

}
