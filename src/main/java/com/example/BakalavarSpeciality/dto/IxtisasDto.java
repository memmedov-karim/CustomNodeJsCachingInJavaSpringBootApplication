package com.example.BakalavarSpeciality.dto;

import com.example.BakalavarSpeciality.entity.Sahe;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class IxtisasDto {
    private String id;
    private String name;
    private String educationtype;
    private String universityName;
    private String universityLocation;
    private String universityShortName;
    private double paidlyscore;
    private double freescore;
    private String educationlanguage;
    private String mainsector;
    private String specialitygroup;
    private String specialityid;
    private int yearlypaid;
    private int planplacenumber;
    private String undergroup;
    private String typeofeducation;
    private String note;
    private int abilitypoint;
    private int abilitypointpaidless;
    private String importantcondition;
    private double percentage;
    private String saheler;
    private List<Sahe> areas;
}
