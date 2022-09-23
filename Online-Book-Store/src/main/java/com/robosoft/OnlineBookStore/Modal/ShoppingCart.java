package com.robosoft.OnlineBookStore.Modal;

import java.time.LocalDate;

public class ShoppingCart {
    private int cartNumber;
    private LocalDate cartDate;
    private String userEmailId;
    private String bookName;
    private double cartAmount;

    public ShoppingCart() {
    }

    public ShoppingCart(int cartNumber, String userEmailId, String bookName, double cartAmount) {
        this.cartNumber = cartNumber;
        //this.cartDate = cartDate;
        this.userEmailId = userEmailId;
        this.bookName = bookName;
        this.cartAmount = cartAmount;
    }

    public int getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(int cartNumber) {
        this.cartNumber = cartNumber;
    }

    public LocalDate getCartDate() {
        return cartDate;
    }

    public void setCartDate(LocalDate cartDate) {
        this.cartDate = cartDate;
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

    public double getCartAmount() {
        return cartAmount;
    }

    public void setCartAmount(double cartAmount) {
        this.cartAmount = cartAmount;
    }
}
