package com.auction.controllers;

import com.auction.model.UserAccount;
import com.auction.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserAccountController {

    @Autowired
    UserAccountService userAccountService;

    /**
     * Post: <code>/user</code>
     *
     * @param userAccount The user to persist in database
     * @return create user
     */
    @PostMapping
    public ResponseEntity<UserAccount> createUser(@RequestParam UserAccount userAccount){
        UserAccount newUserAccount = userAccountService.save(userAccount);
        return new ResponseEntity<>(newUserAccount, HttpStatus.CREATED);
    }

    /**
     * GET: <code>/user/all</code>
     *
     * @return all users
     */
    @RequestMapping("/all")
    public ResponseEntity<List<UserAccount>> getAllUsers(@RequestParam(required = false) String string){
        List<UserAccount> userAccounts = userAccountService.findAll();
        if(userAccounts.isEmpty()){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userAccounts, HttpStatus.OK);
    }

    /**
     * PUT: <code>/user/id</code>
     *
     * @param id            The id of old user to replace
     * @param userAccount   The new User
     * @return updated user in database
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserAccount> updateUser(@PathVariable("id") Long id, @RequestBody UserAccount userAccount){
        UserAccount newUser = userAccountService.update(id, userAccount);
        if (newUser==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    /**
     * DELETE: <code>/user/id</code>
     * @param id The id of user to set inActive
     * @return user inActive
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id){
        boolean success = userAccountService.delete(id);
        if (success){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * GET: <code>/user/id</code>
     *
     * @param id The id of user to get
     * @return user
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> getUserById(@PathVariable("id") Long id){
        Optional<UserAccount> user = userAccountService.findById(id);
        if(user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
