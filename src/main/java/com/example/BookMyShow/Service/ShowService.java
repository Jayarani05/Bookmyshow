package com.example.BookMyShow.Service;

import com.example.BookMyShow.Entity.Movie;
import com.example.BookMyShow.Entity.Screen;
import com.example.BookMyShow.Entity.Show;
import com.example.BookMyShow.Repository.MovieRepository;
import com.example.BookMyShow.Repository.ScreenRepository;
import com.example.BookMyShow.Repository.ShowRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;


    @Service
    public class ShowService {

        private final ShowRepository showRepository;
        private final MovieRepository movieRepository;
        private final ScreenRepository screenRepository;

        public ShowService(ShowRepository showRepository,
                           MovieRepository movieRepository,
                           ScreenRepository screenRepository) {
            this.showRepository = showRepository;
            this.movieRepository = movieRepository;
            this.screenRepository = screenRepository;
        }

        public Show createShow(String movieId, String screenId, LocalDateTime time, double price) {
            Movie movie = movieRepository.findById(movieId).orElseThrow();
            Screen screen = screenRepository.findById(screenId).orElseThrow();

            Show show = new Show(null, movie, screen, time, price);
            return showRepository.save(show);
        }
        @Cacheable("shows")
        public List<Show> getAllShows() {
            return showRepository.findAll();
        }
    }


