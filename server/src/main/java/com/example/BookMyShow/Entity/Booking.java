package com.example.BookMyShow.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import lombok.*;
import java.util.List;


@Document(collection = "bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    private String id;

    @DBRef
    private User user;

    @DBRef
    private Show show;

    @DBRef
    private List<Seat> seats;

    private double totalAmount;
    private String status;
}
