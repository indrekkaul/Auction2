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
@Table(name = "AUCTION")
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long auctionId;
    @Column(name = "auction_title")
    private String auctionTitle;
    @Column(name = "auction_description")
    private String auctionDescription;
    @ManyToOne
    private Category auctionItemCategory;
    @Column(name = "minimum_price")
    private double minimumPrice;
    @Column(name = "buy_now_price")
    private double buyNowPrice;
    @Column(name = "is_promoted_to_premium")
    private boolean isPromotedToPremium;
    @ManyToOne
    private Address userLocation;
    @Column(name = "auction_created")
    private Date auctionCreated;
    @Column(name = "auction_ending")
    private Date auctionEnding;
    @Column(name = "number_of_visits")
    private int numberOfVisits;


}
