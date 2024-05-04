package com.example.BakalavarSpeciality.repository;

import com.example.BakalavarSpeciality.entity.Ixtisas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IxtisasRepository extends JpaRepository<Ixtisas,String> {

    @Query(value = "SELECT * FROM ixtisaslar i WHERE i.specialitygroup=:specialitygroup AND i.undergroup=:undergroup AND i.mainsector=:mainsector AND i.freescore>:min AND i.freescore<:max AND FIND_IN_SET(:id, i.saheler) > 0 ORDER BY i.freescore DESC", nativeQuery = true)
    List<Ixtisas> findBySahelerId(String id,double min,double max,String specialitygroup,String undergroup,String mainsector);
}
