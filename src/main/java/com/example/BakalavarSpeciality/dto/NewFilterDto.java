package com.example.BakalavarSpeciality.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class NewFilterDto {
    private String sector;
    private String specialityGroup;
    private String undergroup;
    private double firstscoreNumber;
    private double secondscoreNumber;
    private List<String> favAreas;
}
