package com.robosoft.MovieTicketBooking.Controller;

import com.robosoft.MovieTicketBooking.Modal.Movie;
import com.robosoft.MovieTicketBooking.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movieTicketBooking/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/addMovie")
    public String addMovie(@RequestBody Movie movie){

        return adminService.addMovie(movie);
    }


}
