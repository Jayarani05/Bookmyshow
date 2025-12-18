package com.example.BookMyShow.Service;

import com.example.BookMyShow.Entity.Booking;
import com.example.BookMyShow.Entity.Payment;
import com.example.BookMyShow.Repository.BookingRepository;
import com.example.BookMyShow.Repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final BookingRepository bookingRepository;

    public PaymentService(PaymentRepository paymentRepository,
                          BookingRepository bookingRepository) {
        this.paymentRepository = paymentRepository;
        this.bookingRepository = bookingRepository;
    }

    public Payment makePayment(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow();
        Payment payment = new Payment(null, booking, booking.getTotalAmount(), "SUCCESS");
        booking.setStatus("CONFIRMED");
        return paymentRepository.save(payment);
    }
}

