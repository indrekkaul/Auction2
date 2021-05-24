package com.example.auction.controllers;

import com.example.auction.model.UserAccount;
import com.example.auction.repositorys.UserAccountRepository;
import com.example.auction.services.implementations.UserAccountServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserAccountController {



    UserAccountRepository userAccountRepository;
    UserAccountServiceImplementation userAccountServiceImplementation;



    @Autowired
    public UserAccountController(UserAccountRepository userAccountRepository,
                                 UserAccountServiceImplementation userAccountServiceImplementation) {
                this.userAccountRepository = userAccountRepository;
                this.userAccountServiceImplementation = userAccountServiceImplementation;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestParam UserAccount userAccount){
        userAccountServiceImplementation.save(userAccount);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

   public ResponseEntity<?> findUserAccount(@PathVariable Long id){
        //UserAccount userAccount = userAccountServiceImplementation.findOne(id);
        //return ResponseEntity<>(userAccount, HttpStatus.OK)
       return null;
   }

    @GetMapping("/register")
    public String showRegistrationFormNewUser(Model model) {
        //model.addAttribute("user", new UserAccount());

        return "register";

    }
    @RequestMapping("/allusers")
    List<UserAccount> getAllUsers(){
        return userAccountRepository.findAll();
    }

    @RequestMapping(value = "/test")
    public String test(){

        return "index";
    }
}
