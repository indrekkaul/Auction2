package com.example.auction.model;

public class Purchasing {

    private int purchasingId;
    private Auction auction;
    private UserAccount user;
    private double finalPrice;
    public int getPurchasingId() {
        return purchasingId;
    }

    public void setPurchasingId(int purchasingId) {
        this.purchasingId = purchasingId;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public UserAccount getUser() {
        return user;
    }

    public void setUser(UserAccount user) {
        this.user = user;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }


}
