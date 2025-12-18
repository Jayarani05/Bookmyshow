package com.example.BookMyShow.Service;



import com.example.BookMyShow.Entity.Theatre;
import com.example.BookMyShow.Repository.TheatreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {

    private final TheatreRepository theatreRepository;

    public TheatreService(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    public Theatre createTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    public Theatre getTheatreById(Long id) {
        return theatreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Theatre not found"));
    }

    public Theatre updateTheatre(Long id, Theatre theatre) {
        Theatre existing = getTheatreById(id);
        existing.setName(theatre.getName());
        existing.setLocation(theatre.getLocation());
        return theatreRepository.save(existing);
    }

    public void deleteTheatre(Long id) {
        theatreRepository.deleteById(id);
    }
}

