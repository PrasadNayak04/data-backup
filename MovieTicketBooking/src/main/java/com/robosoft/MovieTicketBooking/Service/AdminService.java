package com.robosoft.MovieTicketBooking.Service;

import com.robosoft.MovieTicketBooking.Modal.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    String query;

    public String addMovie(Movie movie){
        query = "insert into Movie values (?,?,?)";
        try{
            jdbcTemplate.update(query, movie.getMovieTitle(), movie.getDescription(), movie.getShowTimeDuration());
            return "New movie added successfully";
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "Failed to add movie";
    }

}
