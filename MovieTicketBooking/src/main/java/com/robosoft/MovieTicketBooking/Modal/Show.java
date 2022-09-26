package com.robosoft.MovieTicketBooking.Modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Show {

    private int showId;
    private String movieName;
    private String theatreName;
    private int screenId;
    private String location;
    private Time showTime;
    private int availableSeats;

}
