package com.example.BookMyShow.Service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.BookMyShow.Entity.Screen;
import com.example.BookMyShow.Entity.Seat;
import com.example.BookMyShow.Entity.SeatType;
import com.example.BookMyShow.Repository.ScreenRepository;
import com.example.BookMyShow.Repository.SeatRepository;

@Service
public class SeatService {

    private final SeatRepository seatRepository;
    private final ScreenRepository screenRepository;

    public SeatService(SeatRepository seatRepository, ScreenRepository screenRepository) {
        this.seatRepository = seatRepository;
        this.screenRepository = screenRepository;
    }

    public Seat createSeat(String seatNumber, SeatType seatType, String screenId) {
        Screen screen = screenRepository.findById(screenId)
                .orElseThrow(() -> new RuntimeException("Screen not found"));

        Seat seat = new Seat(null, seatNumber, seatType, screen);
        return seatRepository.save(seat);
    }

    @Cacheable("seats")
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public void deleteSeat(String id) {
        seatRepository.deleteById(id);
    }
}

