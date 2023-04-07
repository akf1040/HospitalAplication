package com.myproject.hospitalaplication.service;


import com.myproject.hospitalaplication.controller.DoctorController;
import com.myproject.hospitalaplication.dto.CreateDoctorRequest;
import com.myproject.hospitalaplication.dto.DoctorDto;
import com.myproject.hospitalaplication.dto.DoctorDtoConverter;
import com.myproject.hospitalaplication.dto.UpdateDoctorRequest;
import com.myproject.hospitalaplication.model.Department;
import com.myproject.hospitalaplication.model.Doctor;
import com.myproject.hospitalaplication.model.NamePrefix;
import com.myproject.hospitalaplication.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    public DoctorDto createDoctor(CreateDoctorRequest createDoctorRequest) {
        Doctor doctor= new Doctor();
        doctor.setId(createDoctorRequest.getId());
        doctor.setName(createDoctorRequest.getName());
        doctor.setNameprefix(NamePrefix.valueOf(createDoctorRequest.getNameprefix().name()));
        doctor.setDepartment(Department.valueOf(createDoctorRequest.getDepartment().name()));
        doctor.setDateOfStart(createDoctorRequest.getDateOfStart());
        doctor.setDateOfGraduate(createDoctorRequest.getDateOfGraduate());
        doctorRepository.save(doctor);

        return DoctorDtoConverter.convert(doctor);
        }


    public DoctorDto updateDoctor(String id, UpdateDoctorRequest updateDoctorRequest) {
     Optional<Doctor > doctorOptional= doctorRepository.findById(id);
     doctorOptional.ifPresent(doctor -> {
         doctor.setName(updateDoctorRequest.getName());
         doctor.setDateOfGraduate(updateDoctorRequest.getDateOfGraduate());
         doctor.setNameprefix(NamePrefix.valueOf(updateDoctorRequest.getNameprefix().name()));
         doctor.setDepartment(Department.valueOf(updateDoctorRequest.getDepartment().name()));
         doctor.setDateOfStart(updateDoctorRequest.getDateOfStart());
         doctorRepository.save(doctor);
     });
        return doctorOptional.map(doctor -> DoctorDtoConverter.convert(doctor)).orElse(new DoctorDto());
    }


    public List<DoctorDto> getAllDoctor() {
        List<Doctor> doctorList=doctorRepository.findAll();

        List<DoctorDto> doctorDtoList=new ArrayList<>();
        for(Doctor doctor:doctorList){
            doctorDtoList.add(DoctorDtoConverter.convert(doctor));
        }
         return doctorDtoList;

    }

    public DoctorDto getDoctorById(String id) {
        Optional<Doctor> doctorOptional=doctorRepository.findById(id);
        return doctorOptional.map(doctor -> DoctorDtoConverter.convert(doctor)).orElse(new DoctorDto());
    }


    public void deleteDoctor(String id) {
        doctorRepository.deleteById(id);
    }
}

