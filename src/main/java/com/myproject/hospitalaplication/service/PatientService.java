package com.myproject.hospitalaplication.service;

import com.myproject.hospitalaplication.dto.CreatePatientRequest;
import com.myproject.hospitalaplication.dto.PatientDto;
import com.myproject.hospitalaplication.dto.PatientDtoConverter;
import com.myproject.hospitalaplication.dto.UpdatePatientRequest;
import com.myproject.hospitalaplication.model.City;
import com.myproject.hospitalaplication.model.Gender;
import com.myproject.hospitalaplication.model.Patient;
import com.myproject.hospitalaplication.repository.PatientRespository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRespository patientRespository;
    private final PatientDtoConverter patientDtoConverter;

    public PatientService(PatientRespository patientRespository, PatientDtoConverter patientDtoConverter) {
        this.patientRespository = patientRespository;
        this.patientDtoConverter = patientDtoConverter;
    }


    public PatientDto createPatient(CreatePatientRequest createPatientRequest) {
        Patient patient = new Patient();
        patient.setId(createPatientRequest.getId());
        patient.setCity(City.valueOf(createPatientRequest.getCity().name()));
        patient.setAdress(createPatientRequest.getAdress());
        patient.setGender(Gender.valueOf(createPatientRequest.getGender().name()));
        patient.setDateOfBirth(createPatientRequest.getDateOfBirth());
        patient.setName(createPatientRequest.getName());
        patient.setHealthInsurance(createPatientRequest.isHealthInsurance());
        patientRespository.save(patient);
        return PatientDtoConverter.convert(patient);
    }

    public PatientDto updatePatient(String id, UpdatePatientRequest updatePatientRequest) {
        Optional<Patient> patientOptional = patientRespository.findById(id);

        patientOptional.ifPresent(patient -> {
            patient.setName(updatePatientRequest.getName());
            patient.setAdress(updatePatientRequest.getAdress());
            patient.setGender(Gender.valueOf(updatePatientRequest.getGender().name()));
            patient.setDateOfBirth(updatePatientRequest.getDateOfBirth());
            patient.setCity(City.valueOf(updatePatientRequest.getCity().name()));
            patient.setHealthInsurance(updatePatientRequest.isHealthInsurance());
        });
        return patientOptional.map(patient -> PatientDtoConverter.convert(patient)).orElse(new PatientDto());

    }

    public List<PatientDto> getAllPatient() {
        List<Patient> patientList = patientRespository.findAll();

        List<PatientDto> patientDtoList = new ArrayList<>();
        for (Patient patient : patientList) {
            patientDtoList.add(PatientDtoConverter.convert(patient));
        }
        return patientDtoList;
    }

    public PatientDto getPatientDtoById(String id) {
        Optional<Patient> patientOptional = patientRespository.findById(id);

        return patientOptional.map(patient -> PatientDtoConverter.convert(patient)).orElse(new PatientDto());
    }

    public void deletePatient(String id) {
        patientRespository.deleteById(id);
    }


    protected Patient getPatientById(String id) {
       Optional<Patient> patientOptional = patientRespository.findById(id);
       Patient patient = new Patient();
        return  patient;
    }

}
