package com.myproject.hospitalaplication.dto;

import com.myproject.hospitalaplication.model.Department;
import com.myproject.hospitalaplication.model.Doctor;
import com.myproject.hospitalaplication.model.NamePrefix;
import org.springframework.stereotype.Component;

@Component
public class DoctorDtoConverter {

    public static DoctorDto convert(Doctor doctor){
        DoctorDto doctorDto=DoctorDto.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .dateOfGraduate(doctor.getDateOfGraduate())
                .dateOfStart(doctor.getDateOfStart())
                .department(Department.valueOf(doctor.getDepartment().name()))
                .nameprefix(NamePrefix.valueOf(doctor.getNameprefix().name()))
                .build();
        return doctorDto;

    }
}
