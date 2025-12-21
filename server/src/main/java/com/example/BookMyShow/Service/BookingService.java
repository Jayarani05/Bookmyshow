package com.example.BookMyShow.Service;

import com.example.BookMyShow.Entity.Booking;
import com.example.BookMyShow.Entity.Seat;
import com.example.BookMyShow.Entity.Show;
import com.example.BookMyShow.Entity.User;
import com.example.BookMyShow.Repository.BookingRepository;
import com.example.BookMyShow.Repository.SeatRepository;
import com.example.BookMyShow.Repository.ShowRepository;
import com.example.BookMyShow.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final ShowRepository showRepository;
    private final SeatRepository seatRepository;

    public BookingService(BookingRepository bookingRepository,
                          UserRepository userRepository,
                          ShowRepository showRepository,
                          SeatRepository seatRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.seatRepository = seatRepository;
    }

    public Booking createBooking(String userId, String showId, List<String> seatIds) {
        User user = userRepository.findById(userId).orElseThrow();
        Show show = showRepository.findById(showId).orElseThrow();
        List<Seat> seats = seatRepository.findAllById(seatIds);

        double total = seats.size() * show.getPrice();

        Booking booking = new Booking(null, user, show, seats, total, "CREATED");
        return bookingRepository.save(booking);
    }
}

