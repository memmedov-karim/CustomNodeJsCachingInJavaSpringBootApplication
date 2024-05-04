package com.example.BakalavarSpeciality.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Getter
@Setter
@Entity
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "custom-id")
    @GenericGenerator(name = "custom-id",strategy = "com.example.BakalavarSpeciality.generator.CustomIdGenerator")
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String short_name;
    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
    private List<Ixtisas> ixtisasalar;
}
