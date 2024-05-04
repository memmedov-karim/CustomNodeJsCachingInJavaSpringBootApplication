package com.example.BakalavarSpeciality.repository;

import com.example.BakalavarSpeciality.entity.Area;
import com.example.BakalavarSpeciality.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality,String> {

    List<Speciality> findByMainsectorInAndSpecialitygroupAndUndergroupAndFreescoreBetween(List<String> mainSectors,String specialityGroup,String undergroup,double min,double max);
    @Query("SELECT s FROM Speciality s WHERE s.area.id = :area_id AND s.mainsector = :mainSector")
    List<Speciality> findByArea_IdAndMainSector(String area_id, String mainSector);

}
