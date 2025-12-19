package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Entity.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}
