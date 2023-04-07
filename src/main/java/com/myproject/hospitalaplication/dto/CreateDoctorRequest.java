package com.myproject.hospitalaplication.dto;

import com.myproject.hospitalaplication.model.Department;
import com.myproject.hospitalaplication.model.NamePrefix;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateDoctorRequest {
    private String id;
    private String name;
    private NamePrefix nameprefix;
    private Department department;
    private int dateOfGraduate;
    private int dateOfStart;
}
