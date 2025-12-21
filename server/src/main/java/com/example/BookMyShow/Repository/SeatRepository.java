package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Entity.Seat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeatRepository extends MongoRepository<Seat, String> {
}

