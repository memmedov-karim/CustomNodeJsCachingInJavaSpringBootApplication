package com.example.BakalavarSpeciality.mapper;

import com.example.BakalavarSpeciality.dto.SpecialityDto;
import com.example.BakalavarSpeciality.entity.Speciality;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;
@Mapper(componentModel = "spring")
public interface SpecialityMapper {
    SpecialityMapper INSTANCE = Mappers.getMapper(SpecialityMapper.class);
    @Mapping(source = "university.name", target = "universityName")
    @Mapping(source = "university.location", target = "universityLocation")
    @Mapping(source = "university.short_name",target = "universityShortName")
    @Mapping(source = "area.name", target = "areaName")
    SpecialityDto specialityToDTO(Speciality speciality);
    List<SpecialityDto> specialitiesToDTOs(List<Speciality> specialities);
}
