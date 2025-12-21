package com.example.BookMyShow.Service;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class CacheDebugService {

    private final CacheManager cacheManager;

    public CacheDebugService(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void printCachedUsers() {

        Cache cache = cacheManager.getCache("users");

        if (cache == null) {
            System.out.println("No cache found with name 'users'");
            return;
        }

        Object cachedValue = cache.getNativeCache();

        System.out.println("Cached Users Data:");
        System.out.println(cachedValue);
    }

    public void printCachedtheatres() {

        Cache cache = cacheManager.getCache("theatres");

        if (cache == null) {
            System.out.println("No cache found with name 'theatres'");
            return;
        }

        Object cachedValue = cache.getNativeCache();

        System.out.println("Cached theatres Data:");
        System.out.println(cachedValue);
    }

    public void printCachedMovies() {

        Cache cache = cacheManager.getCache("movies");

        if (cache == null) {
            System.out.println("No cache found with name 'movies'");
            return;
        }

        Object cachedValue = cache.getNativeCache();

        System.out.println("Cached movies Data:");
        System.out.println(cachedValue);
    }

    public void printCachedShows() {

        Cache cache = cacheManager.getCache("shows");

        if (cache == null) {
            System.out.println("No cache found with name 'shows'");
            return;
        }

        Object cachedValue = cache.getNativeCache();

        System.out.println("Cached shows Data:");
        System.out.println(cachedValue);
    }

    public void printCachedScreen() {

        Cache cache = cacheManager.getCache("screen");

        if (cache == null) {
            System.out.println("No cache found with name 'screen'");
            return;
        }

        Object cachedValue = cache.getNativeCache();

        System.out.println("Cached screen Data:");
        System.out.println(cachedValue);
    }

    public void printCachedSeat() {

        Cache cache = cacheManager.getCache("seats");

        if (cache == null) {
            System.out.println("No cache found with name 'seats'");
            return;
        }

        Object cachedValue = cache.getNativeCache();

        System.out.println("Cached seats Data:");
        System.out.println(cachedValue);
    }
}
