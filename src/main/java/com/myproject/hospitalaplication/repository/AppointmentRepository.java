package com.myproject.hospitalaplication.repository;


import com.myproject.hospitalaplication.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {


}
