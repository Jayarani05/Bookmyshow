package com.example.BookMyShow.Controller;

import com.example.BookMyShow.Entity.Show;
import com.example.BookMyShow.Service.ShowService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shows")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @PostMapping
    public Show createShow(@RequestBody Map<String, String> req) {
        return showService.createShow(
                Long.valueOf(req.get("movieId")),
                Long.valueOf(req.get("screenId")),
                LocalDateTime.parse(req.get("startTime")),
                Double.parseDouble(req.get("price"))
        );
    }

    @GetMapping
    public List<Show> getAllShows() {
        return showService.getAllShows();
    }
}

