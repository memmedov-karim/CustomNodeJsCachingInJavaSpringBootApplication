package com.example.BakalavarSpeciality.catchesystem;

public interface Catch<K,V> {
    void put(K key,V value);
    V get(K key);
    void clear();
    void printKey();

}
