package com.auction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Auction auction;

    @OneToOne
    private UserAccount seller;

    @OneToOne
    private UserAccount buyer;

    private BigDecimal finalPrice;

    private boolean active;

}
