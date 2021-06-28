package com.auction.services.implementations;

import com.auction.model.Address;
import com.auction.repositorys.AddressRepository;
import com.auction.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
            throw new RuntimeException("Cant update record does not exists in database!");
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

    @Override
    public List<Address> findAllByStreetContaining(String string) {
        List<Address> addressesByContainingStreet = new ArrayList<>(addressRepository.findAllByStreetContaining(string));
        return addressesByContainingStreet;

    }

    @Override
    public List<Address> findAllByCountryContaining(String string) {
            List<Address> addressesByContainingCountry = new ArrayList<>(addressRepository.findAllByCountryContaining(string));
            return addressesByContainingCountry;

    }

    @Override
    public List<Address> findAllByZipContaining(String string) {
            List<Address> addressesByContainingZip = new ArrayList<>(addressRepository.findAllByZipContaining(string));
            return addressesByContainingZip;

    }

    @Override
    public List<Address> findAllByCityContaining(String string) {
            List<Address> addressesByContainingCity = new ArrayList<>(addressRepository.findAllByCityContaining(string));
            return addressesByContainingCity;
    }

    public List<Address> findAllContainingString (String string){
        List<Address> addressesContainingString = findAllByStreetContaining(string);
        addressesContainingString.addAll(findAllByZipContaining(string));
        addressesContainingString.addAll(findAllByCityContaining(string));
        addressesContainingString.addAll(findAllByCountryContaining(string));
        Set<Address> removeDuplicates = new LinkedHashSet<>(addressesContainingString);
        addressesContainingString.clear();
        addressesContainingString.addAll(removeDuplicates);
        return addressesContainingString;
    }
}
