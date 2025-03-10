package com.veterinary.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class Pet {
    private String id;
    private String name;
    private String ownerId;
    private int age;
    private String species;
    private String breed;
    private String characteristics;
    private double weight;
    private Map<String, MedicalHistory> medicalHistory;
}

