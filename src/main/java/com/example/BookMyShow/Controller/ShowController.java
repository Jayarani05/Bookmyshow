package com.example.BookMyShow.Controller;

import com.example.BookMyShow.Entity.Show;
import com.example.BookMyShow.Service.ShowService;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shows")


public class ShowController {

    private final ShowService showService;
    private final CacheManager cacheManager;

    public ShowController(ShowService showService,CacheManager cacheManager) {
        this.showService = showService;
        this.cacheManager = cacheManager;
    }

    @PostMapping
    public Show createShow(@RequestBody Map<String, String> req) {
        return showService.createShow(
                req.get("movieId"),
                req.get("screenId"),
                LocalDateTime.parse(req.get("startTime")),
                Double.parseDouble(req.get("price"))
        );
    }

    @GetMapping
    public List<Show> getAllShows() {
        return showService.getAllShows();
    }

    @GetMapping("/cache/print")
    public void printCachedShows() {

        Cache cache = cacheManager.getCache("shows");

        if (cache == null) {
            System.out.println("Cache 'shows' not found");
            return;
        }

        System.out.println("CACHED SHOWS ");
        System.out.println(cache.getNativeCache());

    }
}

