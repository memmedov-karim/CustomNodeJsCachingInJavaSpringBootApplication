package com.example.BakalavarSpeciality.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SahelerDto {
    private List<String> ids;
    private double firstscore;
    private double secondscore;
    private String specialitygroup;
    private String undergroup;
    private String mainsector;
}
