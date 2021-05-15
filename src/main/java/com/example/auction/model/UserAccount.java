package com.example.auction.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String accountName;
    private String email;
    private String password;
    private Address address;
    private Date accountCreated;
    private enum accountStatus{ACTIVE, INACTIVE, BLOCKED}
    private enum accountType{STANDARD, PREMIUM}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getAccountCreated() {
        return accountCreated;
    }

    public void setAccountCreated(Date accountCreated) {
        this.accountCreated = accountCreated;
    }
}
