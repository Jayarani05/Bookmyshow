package com.example.BookMyShow.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import lombok.*;

@Document(collection = "screens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Screen {

    @Id
    private String id;

    private String name;

    @DBRef
    private Theatre theatre;
}
