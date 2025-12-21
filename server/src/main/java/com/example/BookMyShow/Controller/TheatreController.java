package com.example.BookMyShow.Controller;


import org.springframework.cache.CacheManager;

import com.example.BookMyShow.Entity.Theatre;
import com.example.BookMyShow.Service.TheatreService;
import org.springframework.cache.Cache;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreController {

    private final TheatreService theatreService;
    private final CacheManager cacheManager;

    public TheatreController(TheatreService theatreService,CacheManager cacheManager) {
        this.theatreService = theatreService;
        this.cacheManager = cacheManager;
    }

    @PostMapping
    public Theatre createTheatre(@RequestBody Theatre theatre) {
        return theatreService.createTheatre(theatre);
    }

    @GetMapping
    public List<Theatre> getAllTheatres() {
        return theatreService.getAllTheatres();
    }

    @GetMapping("/{id}")
    public Theatre getTheatreById(@PathVariable String id) {
        return theatreService.getTheatreById(id);
    }

    @PutMapping("/{id}")
    public Theatre updateTheatre(@PathVariable String id,
                                 @RequestBody Theatre theatre) {
        return theatreService.updateTheatre(id, theatre);
    }

    @DeleteMapping("/{id}")
    public String deleteTheatre(@PathVariable String id) {
        theatreService.deleteTheatre(id);
        return "Theatre deleted successfully";
    }

    @GetMapping("/cache/print")
    public void printCachedtheatres() {

        Cache cache = cacheManager.getCache("theatres");

        if (cache == null) {
            System.out.println("Cache 'theatres' not found");
            return;
        }

        System.out.println("CACHED THEATRES ");
        System.out.println(cache.getNativeCache());

    }


}

