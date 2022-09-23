package com.robosoft.OnlineBookStore.Modal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStoreSystem {
    private Admin admin;
    private List<User> userList;
    private List<Book> booksList;
    private List<ShoppingCart> shoppingCartList;
    private List<Purchased> purchasedList;

    public BookStoreSystem() {
    }

    public BookStoreSystem(Admin admin, List<User> userList, List<Book> booksList, List<ShoppingCart> shoppingCartList, List<Purchased> purchasedList) {
        this.admin = admin;
        this.userList = userList;
        this.booksList = booksList;
        this.shoppingCartList = shoppingCartList;
        this.purchasedList = purchasedList;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Book> booksList) {
        this.booksList = booksList;
    }

    public List<ShoppingCart> getShoppingCartList() {
        return shoppingCartList;
    }

    public void setShoppingCartList(List<ShoppingCart> shoppingCartList) {
        this.shoppingCartList = shoppingCartList;
    }

    public List<Purchased> getPurchasedList() {
        return purchasedList;
    }

    public void setPurchasedList(List<Purchased> purchasedList) {
        this.purchasedList = purchasedList;
    }

    //Functionalities


}
