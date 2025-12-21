package com.example.BookMyShow.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Document(collection = "theatres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Theatre {

    @Id
    private String id;

    private String name;
    private String location;
}

