package com.example.auction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BIDDING")
public class Bidding {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long biddingId;
    @Column(name = "auction")
    private Auction auction;
    @ManyToMany
    private UserAccount user;
    @Column(name = "price")
    private double price;

}
