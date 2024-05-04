package com.example.BakalavarSpeciality.controller;

import com.example.BakalavarSpeciality.dto.*;
import com.example.BakalavarSpeciality.entity.Ixtisas;
import com.example.BakalavarSpeciality.entity.Sahe;
import com.example.BakalavarSpeciality.entity.Speciality;
import com.example.BakalavarSpeciality.entity.University;
import com.example.BakalavarSpeciality.service.speciality.SpecialityService;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/speciality")
public class SpecialityController {

    private final SpecialityService specialityService;

    @GetMapping
    public ResponseEntity<List<SpecialityDto>> getSpecialityes(){
        return ResponseEntity.status(HttpStatus.CREATED).body(specialityService.getSpecialityes());
    }

    @GetMapping("/{areaid}")
    public ResponseEntity<List<Speciality>> findByAreaId(@RequestBody AreSectorsDto areSectorsDto){

        return ResponseEntity.status(HttpStatus.CREATED).body(specialityService.findByAreaId(areSectorsDto));
    }

    @GetMapping("/result")
    public ResponseEntity<List<SpecialityDto>> studentChoiseSpecialityes(@RequestBody NewFilterDto newFilterDto){

        return ResponseEntity.status(HttpStatus.CREATED).body(specialityService.studentChoiseSpecialityes(newFilterDto));
    }

    @GetMapping("/saheler")
    public ResponseEntity<List<Sahe>> getSaheler(){

        return ResponseEntity.status(HttpStatus.CREATED).body(specialityService.getSaheler());
    }
    @GetMapping("/ixtisaslar")
    public ResponseEntity<List<IxtisasDto>> getIxtisaslar(){

        return ResponseEntity.status(HttpStatus.CREATED).body(specialityService.getIxtisaslar());
    }

    @GetMapping("/ixtisaslarfilter")

    public ResponseEntity<List<IxtisasDto>> getBySahelerIn(@RequestBody SahelerDto sahelerDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(specialityService.getBySahelerIn(sahelerDto));
    }

}
