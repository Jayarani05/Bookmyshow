package com.example.BookMyShow.Controller;


import com.example.BookMyShow.Entity.Seat;
import com.example.BookMyShow.Entity.SeatType;
import com.example.BookMyShow.Service.SeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/seats")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @PostMapping
    public Seat createSeat(@RequestBody Map<String, String> req) {
        return seatService.createSeat(
                req.get("seatNumber"),
                SeatType.valueOf(req.get("seatType")),
                req.get("screenId")
        );
    }

    @GetMapping
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }

    @DeleteMapping("/{id}")
    public String deleteSeat(@PathVariable String id) {
        seatService.deleteSeat(id);
        return "Seat deleted";
    }
}

