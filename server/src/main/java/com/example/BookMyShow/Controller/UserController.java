package com.example.BookMyShow.Controller;



import java.util.List;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookMyShow.Entity.User;
import com.example.BookMyShow.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final CacheManager cacheManager;

    public UserController(UserService userService, CacheManager cacheManager) {
        this.userService = userService;
        this.cacheManager = cacheManager;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id,
                           @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "User delete successfully";

    }

    @GetMapping("/cache/print")
    public void printCachedUsers() {

        Cache cache = cacheManager.getCache("users");

        if (cache == null) {
            System.out.println("Cache 'users' not found");
            return;
        }

        Object cachedData = cache.getNativeCache();

        System.out.println("CACHED USERS ");
        System.out.println(cachedData);
    }

}

