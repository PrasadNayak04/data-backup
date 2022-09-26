package com.robosoft.MovieTicketBooking.Service;

import com.robosoft.MovieTicketBooking.Modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    String query;

    public String register(User user){
        query = "insert into user values (?,?,?,?)";
        try{
            jdbcTemplate.update(query, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber());
            return "Registered successfully";
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "Failed to register";
    }



}
