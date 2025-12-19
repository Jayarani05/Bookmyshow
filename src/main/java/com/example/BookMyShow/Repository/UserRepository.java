package com.example.BookMyShow.Repository;


import com.example.BookMyShow.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
