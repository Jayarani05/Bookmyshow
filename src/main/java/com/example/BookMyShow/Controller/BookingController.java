package com.example.BookMyShow.Controller;

import com.example.BookMyShow.Entity.Booking;
import com.example.BookMyShow.Service.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public Booking createBooking(@RequestBody Map<String, Object> req) {
        return bookingService.createBooking(
                Long.valueOf(req.get("userId").toString()),
                Long.valueOf(req.get("showId").toString()),
                (List<Long>) req.get("seatIds")
        );
    }
}
