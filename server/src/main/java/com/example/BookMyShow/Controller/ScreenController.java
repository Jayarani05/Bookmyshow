package com.example.BookMyShow.Controller;


import com.example.BookMyShow.Entity.Screen;
import com.example.BookMyShow.Service.ScreenService;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/screens")
public class ScreenController {

    private final ScreenService screenService;
    private final CacheManager cacheManager;


    public ScreenController(ScreenService screenService,CacheManager cacheManager) {
        this.screenService = screenService;
        this.cacheManager = cacheManager;
    }

    @PostMapping
    public Screen createScreen(@RequestBody Map<String, Object> request) {
        String name = (String) request.get("name");
        String theatreId = request.get("theatreId").toString();
        return screenService.createScreen(name, theatreId);
    }

    @GetMapping
    public List<Screen> getAllScreens() {
        return screenService.getAllScreens();
    }

    @GetMapping("/{id}")
    public Screen getScreenById(@PathVariable String id) {
        return screenService.getScreenById(id);
    }

    @PutMapping("/{id}")
    public Screen updateScreen(@PathVariable String id,
                               @RequestBody Map<String, Object> request) {
        String name = (String) request.get("name");
        return screenService.updateScreen(id, name);
    }

    @DeleteMapping("/{id}")
    public String deleteScreen(@PathVariable String id) {
        screenService.deleteScreen(id);
        return "Screen deleted successfully";
    }

    @GetMapping("/cache/print")
    public void printCachedScreens() {

        Cache cache = cacheManager.getCache("screens");

        if (cache == null) {
            System.out.println("Cache 'screens' not found");
            return;
        }

        System.out.println("CACHED SCREENS ");
        System.out.println(cache.getNativeCache());

    }




}
