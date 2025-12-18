package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
