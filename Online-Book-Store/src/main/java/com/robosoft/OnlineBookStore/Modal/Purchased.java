package com.robosoft.OnlineBookStore.Modal;

import javax.annotation.Generated;
import java.time.LocalDate;

public class Purchased {
    private int purchaseId;
    private LocalDate purchasedDate;
    private String userEmailId;
    private String bookName;
    private int quantity;
    private double amountPerQuantity;
    private double totalAmount;

    public Purchased() {
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public LocalDate getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(LocalDate purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getAmountPerQuantity() {
        return amountPerQuantity;
    }

    public void setAmountPerQuantity(double amountPerQuantity) {
        this.amountPerQuantity = amountPerQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

}
