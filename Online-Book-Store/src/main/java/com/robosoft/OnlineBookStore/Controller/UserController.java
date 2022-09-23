package com.robosoft.OnlineBookStore.Controller;

import com.robosoft.OnlineBookStore.Modal.Book;
import com.robosoft.OnlineBookStore.Modal.ShoppingCart;
import com.robosoft.OnlineBookStore.Modal.User;
import com.robosoft.OnlineBookStore.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    UserService userService;

    @PostMapping("/register")
    public String userRegister(@RequestBody User user){
        return userService.registerUser(user);
    }

    @GetMapping("/viewbooks")
    public List<Book> viewAvailableBooks(){
        return userService.viewAllBooks();
    }

    @PostMapping("/addtocart")
    public String buyBooks(@RequestBody ShoppingCart shoppingCart){
        return userService.addToCart(shoppingCart);
    }

    @PostMapping("/buybooks/{email}/{quantity}")
    public String buyBooks(@PathVariable String userEmail, @PathVariable int quantity, @RequestBody List<String> buyBookList){
        return userService.addToPurchased(userEmail, quantity, buyBookList);
    }




}
