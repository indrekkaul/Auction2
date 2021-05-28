package com.example.auction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

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

    @ManyToOne
    private UserAccount seller;

    @OneToOne
    private Category itemCategory;

    private BigDecimal minimumPrice;

    private BigDecimal buyNowPrice;

    private boolean isPromotedToPremium;

    @OneToOne
    private Address userLocation;

    private LocalDate created;

    private LocalDate ending;

    private int numberOfVisits;

    private boolean active;


}
