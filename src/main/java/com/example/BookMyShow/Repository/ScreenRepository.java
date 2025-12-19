package com.example.BookMyShow.Repository;
import com.example.BookMyShow.Entity.Screen;

import org.springframework.data.mongodb.repository.MongoRepository;

    public interface ScreenRepository extends MongoRepository<Screen, String> {
    }


