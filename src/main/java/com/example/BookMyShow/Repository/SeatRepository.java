package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}

