package com.example.BakalavarSpeciality.catchesystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SystemCatch<K,V> implements Catch<K,V>{
    private final Map<K,V> cache;
    public SystemCatch() {
        this.cache = new ConcurrentHashMap<>();
    }

    @Override
    public void put(K key,V value){
        cache.put(key,value);
    }

    @Override
    public V get(K key){
        return cache.get(key);
    }

    @Override
    public void clear() {
        cache.clear();
    }

    @Override
    public void printKey(){
        System.out.println(this.cache.keySet());
    }
}
