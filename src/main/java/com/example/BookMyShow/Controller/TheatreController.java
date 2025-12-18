package com.example.BookMyShow.Controller;



import com.example.BookMyShow.Entity.Theatre;
import com.example.BookMyShow.Service.TheatreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreController {

    private final TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
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
    public Theatre getTheatreById(@PathVariable Long id) {
        return theatreService.getTheatreById(id);
    }


}

