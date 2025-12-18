package com.example.BookMyShow.Controller;


import com.example.BookMyShow.Entity.Screen;
import com.example.BookMyShow.Service.ScreenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/screens")
public class ScreenController {

    private final ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }

    @PostMapping
    public Screen createScreen(@RequestBody Map<String, Object> request) {
        String name = (String) request.get("name");
        Long theatreId = Long.valueOf(request.get("theatreId").toString());
        return screenService.createScreen(name, theatreId);
    }

    @GetMapping
    public List<Screen> getAllScreens() {
        return screenService.getAllScreens();
    }


}
