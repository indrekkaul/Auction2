package com.auction.repositorys;

import com.auction.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAllByActive(boolean active);

    List<Address> findAllByCity(String city);

    List<Address> findAllByStreet(String street);

    List<Address> findAllByCountry(String country);

    List<Address> findAllByCityContaining(String string);

    List<Address> findAllByStreetContaining(String string);

    List<Address> findAllByCountryContaining(String string);

    List<Address> findAllByZipContaining(String string);



}
