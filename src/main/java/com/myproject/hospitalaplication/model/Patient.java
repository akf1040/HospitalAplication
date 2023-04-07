package com.myproject.hospitalaplication.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Patient {

    @Id
    private String id;
    private String name;
    private Gender gender;
    private int dateOfBirth;
    private String adress;
    private boolean healthInsurance;
    private City city;


}
