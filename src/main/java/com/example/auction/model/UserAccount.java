package com.example.auction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER_ACCOUNT")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column(name = "account_name")
    private String accountName;
    @Column(name = "email") // Also User login name!
    private String email;
    @Column(name = "password")
    private String password;

    @ManyToOne(optional = false)
    private Address address;

    @Column(name = "account_created")
    private Date accountCreated;

    private enum accountStatus{ACTIVE, INACTIVE, BLOCKED}
    private enum accountType{STANDARD, PREMIUM}


}
