package com.example.BookMyShow.Repository;


import com.example.BookMyShow.Entity.Theatre;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TheatreRepository extends MongoRepository<Theatre, String> {
}
