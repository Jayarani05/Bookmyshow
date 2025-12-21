package com.example.BookMyShow.Controller;

import java.util.List;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.http.MediaType;
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

    @GetMapping(value = "/status", produces = MediaType.TEXT_HTML_VALUE)
    public String getStatus() {
        return """
                <!DOCTYPE html>
                <html>
                <head>
                    <title>BookMyShow API</title>
                    <style>
                        body {
                            font-family: Arial, sans-serif;
                            display: flex;
                            justify-content: center;
                            align-items: center;
                            height: 100vh;
                            margin: 0;
                            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
                        }
                        .container {
                            text-align: center;
                            background: white;
                            padding: 40px;
                            border-radius: 10px;
                            box-shadow: 0 10px 25px rgba(0,0,0,0.2);
                        }
                        h1 {
                            color: #667eea;
                            margin: 0;
                        }
                        .status {
                            color: #ffe72eff;
                            font-size: 24px;
                            margin: 20px 0;
                        }
                        .icon {
                            font-size: 60px;
                            margin-bottom: 20px;
                        }
                    </style>
                </head>
                <body>
                    <div class="container">
                        <div class="icon">🎬</div>
                        <h1>BookMyShow API</h1>
                        <div class="status">✅ Application Running Successfully! Server will restart automatically on code changes.</div>
                        <p>Server is up and running on port 8080</p>
                    </div>
                </body>
                </html>
                """;
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
