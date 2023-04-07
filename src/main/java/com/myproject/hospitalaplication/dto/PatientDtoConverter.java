package com.myproject.hospitalaplication.dto;

import com.myproject.hospitalaplication.model.City;
import com.myproject.hospitalaplication.model.Gender;
import com.myproject.hospitalaplication.model.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientDtoConverter {
    public static   PatientDto convert(Patient patient){
        PatientDto patientDto=PatientDto.builder()
                .adress(patient.getAdress())
                .city(City.valueOf(patient.getCity().name()))
                .dateOfBirth(patient.getDateOfBirth())
                .gender(Gender.valueOf(patient.getGender().name()))
                .healthInsurance(patient.isHealthInsurance())
                .id(patient.getId())
                .name(patient.getName())
                .build();
        return  patientDto;
    }
}
