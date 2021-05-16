package com.example.auction.services;

import com.example.auction.model.Address;

import java.util.List;

public interface AddressService {

    Address findOne(Long id);

    void save(Address address);

    void update(Long id, Address address);

    void delete(Long id);

    void restore(Long id);
}
