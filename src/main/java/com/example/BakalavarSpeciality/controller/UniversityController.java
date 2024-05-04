package com.example.BakalavarSpeciality.controller;

import com.example.BakalavarSpeciality.entity.University;
import com.example.BakalavarSpeciality.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/university")
public class UniversityController {



    private final UniversityService universityService;


    @GetMapping
    public ResponseEntity<List<University>> getUniversityes(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(universityService.getUniversityes());
    }
 }
