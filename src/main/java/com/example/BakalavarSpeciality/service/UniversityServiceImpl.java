package com.example.BakalavarSpeciality.service;

import com.example.BakalavarSpeciality.entity.University;
import com.example.BakalavarSpeciality.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService{
    private final UniversityRepository universityRepository;
    @Override
    public List<University> getUniversityes(){


        return universityRepository.findAll();
    }
}
