package com.example.BookMyShow.Controller;

import com.example.BookMyShow.Entity.Booking;
import com.example.BookMyShow.Service.BookingService;
import com.example.BookMyShow.dto.CreateBookingRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public Booking createBooking(@Valid @RequestBody CreateBookingRequest req) {
        return bookingService.createBooking(
                req.getUserId(),
                req.getShowId(),
                req.getSeatIds()
        );
    }
} 
