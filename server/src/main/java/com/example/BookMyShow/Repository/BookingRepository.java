package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Entity.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, String> {
}

