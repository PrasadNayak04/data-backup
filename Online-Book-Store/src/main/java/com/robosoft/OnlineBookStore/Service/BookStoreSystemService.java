package com.robosoft.OnlineBookStore.Service;

import com.robosoft.OnlineBookStore.Modal.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookStoreSystemService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    String query;

    public List<Book> viewAllBooks(){
        query = "select * from book";
        try {
            return jdbcTemplate.query(query, new BeanPropertyRowMapper<Book>(Book.class));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Book viewBookByName(String bookName){
        query = "select * from book where BookName = ?";
        try {
            return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<Book>(Book.class));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Book> selectBooksToBuy(List<String> buyBookList){
        List<Book> booksList = new ArrayList<Book>();
        for(String bookName : buyBookList) {
            query = "select * from book where BookName = '" + bookName + "'";
            try {
                Book b = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<Book>(Book.class));
                booksList.add(b);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return booksList;
    }

    public void removeBookFromCart(String userEmail, String bookName){
        query = "delete from ShoppingCart where UserEmail = ? and BookName = ?";
        try {
            jdbcTemplate.update(query, userEmail, bookName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Cart with user : " + userEmail + " and book : " + bookName + "removed");
    }

}
