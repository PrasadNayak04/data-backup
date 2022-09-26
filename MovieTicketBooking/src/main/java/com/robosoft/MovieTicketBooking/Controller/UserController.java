package com.robosoft.MovieTicketBooking.Controller;

import com.robosoft.MovieTicketBooking.Modal.User;
import com.robosoft.MovieTicketBooking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movieTicketBooking/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")

    public String userRegister(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("/booking{email}/{password}/{show_id}")

    public String userRegister(@PathVariable String email, @PathVariable String password, @PathVariable int show_id){
        return "";
    }

}
