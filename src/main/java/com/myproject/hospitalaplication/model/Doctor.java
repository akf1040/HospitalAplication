package com.myproject.hospitalaplication.model;


import lombok.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doctor {
     @Id
    private String id;

    private String name;
    private NamePrefix nameprefix;
    private Department department;
    private int dateOfGraduate;
    private int dateOfStart;
}
