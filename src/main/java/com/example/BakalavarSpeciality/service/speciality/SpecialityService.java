package com.example.BakalavarSpeciality.service.speciality;

import com.example.BakalavarSpeciality.dto.*;
import com.example.BakalavarSpeciality.entity.Ixtisas;
import com.example.BakalavarSpeciality.entity.Sahe;
import com.example.BakalavarSpeciality.entity.Speciality;
import com.example.BakalavarSpeciality.entity.University;
import org.json.JSONException;

import java.util.List;


public interface SpecialityService {
    List<SpecialityDto> getSpecialityes();

    University getSpecilaityUni(String spid);

    List<SpecialityDto> studentChoiseSpecialityes(NewFilterDto newFilterDto);

    List<Speciality> findByAreaId(AreSectorsDto areSectorsDto);

    List<Sahe> getSaheler();
    List<IxtisasDto> getIxtisaslar();

    List<IxtisasDto> getBySahelerIn(SahelerDto sahelerDto) throws JSONException;

}
