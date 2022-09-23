package com.robosoft.OnlineBookStore.Service;

import com.robosoft.OnlineBookStore.Modal.Book;
import com.robosoft.OnlineBookStore.Modal.BookStoreSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends BookStoreSystemService{
    @Autowired
    JdbcTemplate jdbcTemplate;
    String query;

    public String addBook(Book book){
        query = "insert into book values(?,?,?)";
        try {
            jdbcTemplate.update(query, book.getBookName(), book.getAuthorName(), book.getBookAmount());
            return "Book added successfully";
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "Failed to add the book";
    }

    public String removeBook(String bookName){
        query = "delete from book where BookName = ?";
        try {
            int status = jdbcTemplate.update(query, bookName);
            if(status == 1){
                return "Book '"+ bookName + "' removed successfully";
            }
            return "No book found with name " + bookName;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "Failed to remove the book";

    }

    public String updateBookAmount(String bookName, double newAmount){
        query = "update book set Amount = ? where BookName = ? ";
        try {
            jdbcTemplate.update(query, newAmount, bookName);
            return "Book price updated successfully";
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "Update failed";
    }



}
