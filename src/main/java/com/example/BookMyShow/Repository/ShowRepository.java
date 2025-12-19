package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Entity.Show;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShowRepository extends MongoRepository<Show, String> {
}

