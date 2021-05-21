package com.example.auction.controllers;

import com.example.auction.model.Address;
import com.example.auction.repositorys.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    AddressRepository addressRepository;

    @Autowired
    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping("/registerAddress")
    public String showRegistrationFormNewAddress(Model model) {
        //model.addAttribute("Address", new Address());

        return "register";

    }
    @RequestMapping("/address")
    List<Address> getAllUsers(){
        return addressRepository.findAll();
    }


}
