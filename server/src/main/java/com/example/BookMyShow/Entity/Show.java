package com.example.BookMyShow.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;

@Document(collection = "shows")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Show {

    @Id
    private String id;

    @DBRef
    private Movie movie;

    @DBRef
    private Screen screen;

    private LocalDateTime startTime;
    private double price;
}

