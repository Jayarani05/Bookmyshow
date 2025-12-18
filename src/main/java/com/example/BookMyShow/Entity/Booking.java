package com.example.BookMyShow.Entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Show show;

    @ManyToMany
    private List<Seat> seats;

    private double totalAmount;
    private String status;
}
