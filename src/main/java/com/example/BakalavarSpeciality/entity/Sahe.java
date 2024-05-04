package com.example.BakalavarSpeciality.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
@Table(name = "saheler")
public class Sahe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "custom-id")
    @GenericGenerator(name = "custom-id",strategy = "com.example.BakalavarSpeciality.generator.CustomIdGenerator")
    private String id;
    private String name;
}
