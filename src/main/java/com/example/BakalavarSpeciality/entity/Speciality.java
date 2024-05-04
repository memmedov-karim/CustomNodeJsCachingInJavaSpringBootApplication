package com.example.BakalavarSpeciality.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@Table(name = "specialityes")
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "custom-id")
    @GenericGenerator(name = "custom-id",strategy = "com.example.BakalavarSpeciality.generator.CustomIdGenerator")
    private String id;

    private String name;
    private String educationtype;
    @ManyToOne
    @JoinColumn(name="university_id",nullable = false)
    @JsonIgnore
    private University university;
    private double paidlyscore=0.0;
    private double freescore=0.0;
    private String educationlanguage;
    private String mainsector;
    private String specialitygroup;
    private String specialityid;
    private int yearlypaid;
    @Column(nullable = true)
    private int planplacenumber;
    private String undergroup;
    @ManyToOne
    @JoinColumn(name = "area_id",nullable = true)
    @JsonIgnore
    private Area area;
    private String typeofeducation;
    private String note;
    private int abilitypoint=0;
    private int abilitypointpaidless=0;
    private String importantcondition;
}
