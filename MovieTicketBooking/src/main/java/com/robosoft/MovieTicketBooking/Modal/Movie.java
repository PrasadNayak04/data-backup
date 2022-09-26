package com.robosoft.MovieTicketBooking.Modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private String movieTitle;
    private String description;
    private Time showTimeDuration;

}
