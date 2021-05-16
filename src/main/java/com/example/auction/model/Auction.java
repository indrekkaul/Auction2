package com.example.auction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    @OneToOne
    private Category itemCategory;

    private BigDecimal minimumPrice;

    private BigDecimal buyNowPrice;

    private boolean isPromotedToPremium;

    @OneToOne
    private Address userLocation;

    private Date created;

    private Date ending;

    private int numberOfVisits;


}
