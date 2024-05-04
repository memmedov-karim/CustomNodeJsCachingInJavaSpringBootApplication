package com.example.BakalavarSpeciality.repository;

import com.example.BakalavarSpeciality.entity.Sahe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaheRepository extends JpaRepository<Sahe,String> {
    List<Sahe> findByIdIn(String[] ids);
}
