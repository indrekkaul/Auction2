package com.example.auction.model;

public class TransactionEvaluation {
    private int transactionId;
    private Purchasing purchase;
    private double sellerRating;
    private String sellerComment;
    private double buyerRating;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Purchasing getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchasing purchase) {
        this.purchase = purchase;
    }

    public double getSellerRating() {
        return sellerRating;
    }

    public void setSellerRating(double sellerRating) {
        this.sellerRating = sellerRating;
    }

    public String getSellerComment() {
        return sellerComment;
    }

    public void setSellerComment(String sellerComment) {
        this.sellerComment = sellerComment;
    }

    public double getBuyerRating() {
        return buyerRating;
    }

    public void setBuyerRating(double buyerRating) {
        this.buyerRating = buyerRating;
    }
}
