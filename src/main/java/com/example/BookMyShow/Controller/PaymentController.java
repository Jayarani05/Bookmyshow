package com.example.BookMyShow.Controller;

import com.example.BookMyShow.Entity.Payment;
import com.example.BookMyShow.Service.PaymentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/{bookingId}")
    public Payment pay(@PathVariable String bookingId) {
        return paymentService.makePayment(bookingId);
    }
} 
