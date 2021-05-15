package com.example.auction.model;

import java.util.Date;

public class Auction {
    private int auctionId;
    private String auctionTitle;
    private String auctionDescription;
    private Category auctionItemCategory;
    private double minimumPrice;
    private double buyNowPrice;
    private boolean isPromotedToPremium;
    private Address userLocation;
    private Date auctionCreated;
    private Date auctionEnding;
    private int numberOfVisits;

    public int getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(int auctionId) {
        this.auctionId = auctionId;
    }

    public String getAuctionTitle() {
        return auctionTitle;
    }

    public void setAuctionTitle(String auctionTitle) {
        this.auctionTitle = auctionTitle;
    }

    public String getAuctionDescription() {
        return auctionDescription;
    }

    public void setAuctionDescription(String auctionDescription) {
        this.auctionDescription = auctionDescription;
    }

    public Category getAuctionItemCategory() {
        return auctionItemCategory;
    }

    public void setAuctionItemCategory(Category auctionItemCategory) {
        this.auctionItemCategory = auctionItemCategory;
    }

    public double getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(double minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public double getBuyNowPrice() {
        return buyNowPrice;
    }

    public void setBuyNowPrice(double buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
    }

    public boolean isPromotedToPremium() {
        return isPromotedToPremium;
    }

    public void setPromotedToPremium(boolean promotedToPremium) {
        isPromotedToPremium = promotedToPremium;
    }

    public Address getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(Address userLocation) {
        this.userLocation = userLocation;
    }

    public Date getAuctionCreated() {
        return auctionCreated;
    }

    public void setAuctionCreated(Date auctionCreated) {
        this.auctionCreated = auctionCreated;
    }

    public Date getAuctionEnding() {
        return auctionEnding;
    }

    public void setAuctionEnding(Date auctionEnding) {
        this.auctionEnding = auctionEnding;
    }

    public int getNumberOfVisits() {
        return numberOfVisits;
    }

    public void setNumberOfVisits(int numberOfVisits) {
        this.numberOfVisits = numberOfVisits;
    }
}
