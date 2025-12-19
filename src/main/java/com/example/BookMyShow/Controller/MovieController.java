package com.example.BookMyShow.Controller;


import com.example.BookMyShow.Entity.Movie;
import com.example.BookMyShow.Service.MovieService;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;
    private final CacheManager cacheManager;
    public MovieController(MovieService movieService,CacheManager cacheManager) {
        this.movieService = movieService;
        this.cacheManager = cacheManager;
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable String id) {
        return movieService.getMovieById(id);
    }


    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable String id,
                             @RequestBody Movie movie) {
        return movieService.updateMovie(id, movie);
    }

    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable String id) {
        movieService.deleteMovie(id);
        return "Movie deleted successfully";
    }

    @GetMapping("/cache/print")
    public void printCachedMovies() {

        Cache cache = cacheManager.getCache("theatres");

        if (cache == null) {
            System.out.println("Cache 'theatres' not found");
            return;
        }

        System.out.println("CACHED THEATRES ");
        System.out.println(cache.getNativeCache());

    }


}

