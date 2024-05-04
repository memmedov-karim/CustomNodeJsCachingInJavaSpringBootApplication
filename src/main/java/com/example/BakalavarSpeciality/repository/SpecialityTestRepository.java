package com.example.BakalavarSpeciality.repository;

import com.example.BakalavarSpeciality.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialityTestRepository extends JpaRepository<Speciality,String> {

    List<Speciality> findByArea_IdAndEducationtype(String area_id, String mainSector);
}
