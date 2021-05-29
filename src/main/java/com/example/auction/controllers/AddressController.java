package com.example.auction.controllers;

import com.example.auction.model.Address;
import com.example.auction.repositorys.AddressRepository;
import com.example.auction.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/registerAddress")
    public String showRegistrationFormNewAddress(Model model) {
        //model.addAttribute("Address", new Address());

        return "register";

    }
    @RequestMapping("/allAddress")
    List<Address> getAllUsers(){
        return addressService.findAll();
    }


}
