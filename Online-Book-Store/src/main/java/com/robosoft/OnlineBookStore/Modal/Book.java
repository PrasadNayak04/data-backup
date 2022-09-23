package com.robosoft.OnlineBookStore.Modal;

public class Book {
    private String bookName;
    private String authorName;
    private double bookAmount;

    public Book() {
    }

    public Book(int bookId, String bookName, String authorName, double bookAmount) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookAmount = bookAmount;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public double getBookAmount() {
        return bookAmount;
    }

    public void setBookAmount(double bookAmount) {
        this.bookAmount = bookAmount;
    }


}
