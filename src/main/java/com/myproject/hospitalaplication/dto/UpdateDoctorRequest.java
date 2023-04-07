package com.myproject.hospitalaplication.dto;


import com.myproject.hospitalaplication.model.Department;
import com.myproject.hospitalaplication.model.NamePrefix;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDoctorRequest {
    private String name;
    private NamePrefix nameprefix;
    private Department department;
    private int dateOfGraduate;
    private int dateOfStart;


}
