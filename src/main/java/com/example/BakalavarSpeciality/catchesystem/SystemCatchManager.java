package com.example.BakalavarSpeciality.catchesystem;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Component
public class SystemCatchManager {

    private final Map<String,Catch<?,?>> catches;

    public SystemCatchManager() {
        this.catches = new ConcurrentHashMap<>();
    }
    public <K, V> Catch<K, V> createCache(String name) {
        Catch<K, V> cache = new SystemCatch<>();
        this.catches.put(name, cache);
        return cache;
    }
    public <K, V> Catch<K, V> getCache(String name) {
        return (Catch<K, V>) this.catches.get(name);
    }
    public void clearCache(String name) {
        Catch<?, ?> cache = this.catches.get(name);
        if (cache != null) {
            cache.clear();
        }
    }

    public void printCreatedCaches() {
        System.out.println("Created Caches:");
        for (String name : catches.keySet()) {
            this.getCache(name).printKey();
        }
    }
}
