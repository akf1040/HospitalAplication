package com.myproject.hospitalaplication.dto;


import com.myproject.hospitalaplication.model.Department;
import com.myproject.hospitalaplication.model.NamePrefix;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorDto {
    private String id;
    private String name;
    private NamePrefix nameprefix;
    private Department department;
    private int dateOfGraduate;
    private int dateOfStart;
}
