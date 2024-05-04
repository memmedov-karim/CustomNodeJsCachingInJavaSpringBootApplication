package com.example.BakalavarSpeciality.mapper;

import com.example.BakalavarSpeciality.dto.IxtisasDto;
import com.example.BakalavarSpeciality.dto.SpecialityDto;
import com.example.BakalavarSpeciality.entity.Ixtisas;
import com.example.BakalavarSpeciality.entity.Speciality;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;
@Mapper(componentModel = "spring")
public interface IxtisasMapper {
    IxtisasMapper INSTANCE = Mappers.getMapper(IxtisasMapper.class);
    @Mapping(source = "university.name", target = "universityName")
    @Mapping(source = "university.location", target = "universityLocation")
    @Mapping(source = "university.short_name",target = "universityShortName")
    IxtisasDto ixtisasToDTO(Ixtisas ixtisas);
    List<IxtisasDto> ixtisaslarToDTOs(List<Ixtisas> ixtisaslar);
}
