package com.example.BookMyShow.Repository;


import com.example.BookMyShow.Entity.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {
}

