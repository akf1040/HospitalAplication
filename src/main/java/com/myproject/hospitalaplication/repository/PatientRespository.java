package com.myproject.hospitalaplication.repository;

import com.myproject.hospitalaplication.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRespository extends JpaRepository<Patient,String> {
}
