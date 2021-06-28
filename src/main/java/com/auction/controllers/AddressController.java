package com.auction.controllers;

import com.auction.model.Address;
import com.auction.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * POST: <code>/address</code>
     *
     * @param address The Address to persist in database
     * @return created address
     */
    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        Address newAddress = addressService.save(address);
        return new ResponseEntity<>(newAddress, HttpStatus.CREATED);
    }

    /**
     * GET: <code>/address/all</code>
     * @return all addresses
     *
     */

    @RequestMapping("/all")
    public ResponseEntity<List<Address>> getAllAddresses(@RequestParam(required = false) String all){
        List<Address> addresses = addressService.findAll();
        if (addresses.isEmpty()){
            return new ResponseEntity<>(Collections.emptyList(),HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(addresses,HttpStatus.OK);
    }

    /**
     * GET: <code>/address/"user input"</code>
     * @return all addresses by "user input
     *
     */

    @RequestMapping("/{string}")
    public ResponseEntity<List<Address>> getAllByContaining(@PathVariable(value = "string",  required = false) String string){
        List<Address> addressesContainingString = addressService.findAllContainingString(string);
        if(string.length()<1){
            List<Address> addresses = addressService.findAll();
            return new ResponseEntity<>(addresses,HttpStatus.OK);
        }

        if (addressesContainingString.isEmpty()){
            return new ResponseEntity<>(Collections.emptyList(),HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(addressesContainingString,HttpStatus.OK);
    }

    /**
     * PUT: <code>/address/id</code>
     *
     * @param id        The id of the old address to replace
     * @param address  The new address
     * @return updated address in database
     */
    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable("id") Long id, @RequestBody Address address){
        Address newAddress = addressService.update(id,address);
        if (newAddress == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newAddress, HttpStatus.OK);
    }

    /**
     * DELETE: <code>/address/id</code>
     *
     * @param id The id of the address to set inActive
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAddress(@PathVariable("id") Long id){
        boolean success = addressService.delete(id);
        if (success){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
