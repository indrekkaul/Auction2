package com.example.auction.services.implementations;

import com.example.auction.model.Address;
import com.example.auction.repositorys.AddressRepository;
import com.example.auction.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImplementation implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImplementation(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public Address findOne(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Address not found!"));
    }

    @Override
    public void save(Address address) {
        addressRepository.saveAndFlush(address);
    }

    @Override
    public void update(Long id, Address address) {
        Address oldAddress = findOne(address.getId());
        oldAddress.setStreet(address.getStreet());
        oldAddress.setCity(address.getCity());
        oldAddress.setCountry(address.getCountry());

        save(oldAddress);

    }

    @Override
    public void delete(Long id) {
        Address addressDelete = findOne(id);
        addressDelete.setActive(false);
        save(addressDelete);
    }

    @Override
    public void restore(Long id) {
        Address addressRestore = findOne(id);
        addressRestore.setActive(true);
        save(addressRestore);

    }
}
