package com.example.BookMyShow.Service;

import com.example.BookMyShow.Entity.Movie;
import com.example.BookMyShow.Repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(String id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
    }


    public Movie updateMovie(String id, Movie movie) {
        Movie existing = getMovieById(id);
        existing.setTitle(movie.getTitle());
        existing.setLanguage(movie.getLanguage());
        existing.setDuration(movie.getDuration());
        existing.setGenre(movie.getGenre());
        return movieRepository.save(existing);
    }

    public void deleteMovie(String id) {
        movieRepository.deleteById(id);
    }


}

