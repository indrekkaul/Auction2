package com.auction.services;

import com.auction.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    Optional<Address> findOne(Long id);

    List<Address> findAll();

    List<Address> findByStreet(String street);

    List<Address> findByCity(String city);

    Address save(Address address);

    Address update(Long id, Address address);

    boolean delete(Long id);

    void restore(Long id);

    List<Address> findAllByCityContaining(String string);

    List<Address> findAllByStreetContaining(String string);

    List<Address> findAllByCountryContaining(String string);

    List<Address> findAllByZipContaining(String string);

    List<Address> findAllContainingString (String string);

}
