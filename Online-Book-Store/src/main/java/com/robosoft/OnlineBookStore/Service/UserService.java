package com.robosoft.OnlineBookStore.Service;

import com.robosoft.OnlineBookStore.Modal.Book;
import com.robosoft.OnlineBookStore.Modal.ShoppingCart;
import com.robosoft.OnlineBookStore.Modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.List;

public class UserService extends BookStoreSystemService{

    @Autowired
    JdbcTemplate jdbcTemplate;
    String query;
    static int cartNumber = 1;
    static int purchasedId = 101;

    public String registerUser(User user){
        query = "insert into user values(?,?,?)";
        try {
            jdbcTemplate.update(query, user.getUserEmailId(), user.getUserName(), user.getPhoneNumber());
            return "User registration successful";
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "Couldn't able to register";
    }

    public String addToCart(ShoppingCart shoppingCart){
        Book book = viewBookByName(shoppingCart.getBookName());
        query = "insert into ShoppingCart values (?,?,?,?,?)";
        try {
            jdbcTemplate.update(query, this.cartNumber++, LocalDate.now(), shoppingCart.getUserEmailId(), book.getBookName(), book.getBookAmount());
            return "Book added to cart";
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "Failed to add cart";
    }

    public String addToPurchased(String userEmail, int quantity, List<String> buyBookList){
        List<Book> purchasedList = selectBooksToBuy(buyBookList);
        User user = jdbcTemplate.queryForObject("select * from user where email = '" + userEmail + "'", new BeanPropertyRowMapper<User>(User.class));
        for(Book book : purchasedList) {
            query = "insert into Purchased values (?,?,?,?,?)";
            try {
                jdbcTemplate.update(query, purchasedId++, LocalDate.now(), user.getUserEmailId(), book.getBookName(), quantity, book.getBookAmount(), quantity*book.getBookAmount());
                removeBookFromCart(user.getUserEmailId(), book.getBookName());
                System.out.println("Book " + book.getBookName() + " added to purchased");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Book " + book.getBookName() + " purchase failed");
        }
        return "Given books successfully added to purchased list";
    }


}
