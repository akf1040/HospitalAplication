package com.myproject.hospitalaplication.repository;

import com.myproject.hospitalaplication.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, String> {
}
