package com.example.BookMyShow.Repository;


import com.example.BookMyShow.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
