package com.example.BookMyShow.Service;


import com.example.BookMyShow.Entity.Screen;
import com.example.BookMyShow.Entity.Theatre;
import com.example.BookMyShow.Repository.ScreenRepository;
import com.example.BookMyShow.Repository.TheatreRepository;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

@Service
public class ScreenService {

    private final ScreenRepository screenRepository;
    private final TheatreRepository theatreRepository;

    public ScreenService(ScreenRepository screenRepository,
                         TheatreRepository theatreRepository) {
        this.screenRepository = screenRepository;
        this.theatreRepository = theatreRepository;
    }

    public Screen createScreen(String name, String theatreId) {
        Theatre theatre = theatreRepository.findById(theatreId)
                .orElseThrow(() -> new RuntimeException("Theatre not found"));

        Screen screen = new Screen();
        screen.setName(name);
        screen.setTheatre(theatre);

        return screenRepository.save(screen);
    }

    @Cacheable("screens")
    public List<Screen> getAllScreens() {
        return screenRepository.findAll();
    }

    public Screen getScreenById(String id) {
        return screenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Screen not found"));
    }

    public Screen updateScreen(String id, String name) {
        Screen screen = getScreenById(id);
        screen.setName(name);
        return screenRepository.save(screen);
    }

    public void deleteScreen(String id) {
        screenRepository.deleteById(id);
    }


}
