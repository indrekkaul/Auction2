package com.example.auction.services.implementations;

import com.example.auction.model.Address;
import com.example.auction.repositorys.AddressRepository;
import com.example.auction.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImplementation implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Optional<Address> findOne(Long id) {
        return Optional.ofNullable(addressRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Address not found!")));
    }

    @Override
    public List<Address> findAll() {
        List<Address> addresses = new ArrayList<>(addressRepository.findAll());
        return addresses;
    }

    @Override
    public List<Address> findByStreet(String street) {
        if (street == null){
            return addressRepository.findAll();
        }else {
            List<Address> addressesByStreet = new ArrayList<>(addressRepository.findAllByStreet(street));
            return addressesByStreet;
        }
    }

    @Override
    public List<Address> findByCity(String city) {
        if (city == null){
            return addressRepository.findAll();
        }else {
            List<Address> addressesByCity = new ArrayList<>(addressRepository.findAllByStreet(city));
            return addressesByCity;
        }
    }

    @Override
    public Address save(Address address) {
        return addressRepository.saveAndFlush(address);
    }

    @Override
    public Address update(Long id, Address newAddress) {
        Optional<Address> oldAddress =findOne(id);
        if (oldAddress.isPresent()) {
            Address tempAddress = oldAddress.get();
            tempAddress.setCity(newAddress.getCity());
            tempAddress.setState(newAddress.getState());
            tempAddress.setCountry(newAddress.getCountry());
            tempAddress.setStreet(newAddress.getStreet());
            tempAddress.setZip(newAddress.getZip());

            return save(tempAddress);
        }else {
            throw new RuntimeException("Cant Update!");
        }

    }

    @Override
    public boolean delete(Long id) {
        Address addressDelete = addressRepository.getOne(id);
        addressDelete.setActive(false);
        save(addressDelete);
        return true;
    }

    @Override
    public void restore(Long id) {
        Address addressRestore = addressRepository.getOne(id);
        addressRestore.setActive(true);
        save(addressRestore);

    }
}
