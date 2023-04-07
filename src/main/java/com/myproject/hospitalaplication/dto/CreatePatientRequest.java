package com.myproject.hospitalaplication.dto;

import com.myproject.hospitalaplication.model.City;
import com.myproject.hospitalaplication.model.Gender;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CreatePatientRequest {
    private String id;
    private String name;
    private Gender gender;
    private int dateOfBirth;
    private String adress;
    private boolean healthInsurance;
    private City city;
}
