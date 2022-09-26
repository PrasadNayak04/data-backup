package com.robosoft.MovieTicketBooking.Modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingHistory {

    private int bookingId;
    private String userEmail;
    private String movieName;
    private int showId;
    private int numberOfSeats;
    private String theatreName;
    private int screenId;
    private String location;
    private Time showTime;
    private Date dateOfShow;

}
