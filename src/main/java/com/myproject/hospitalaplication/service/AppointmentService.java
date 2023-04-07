package com.myproject.hospitalaplication.service;


import com.myproject.hospitalaplication.dto.*;
import com.myproject.hospitalaplication.model.Appointment;
import com.myproject.hospitalaplication.model.Patient;
import com.myproject.hospitalaplication.repository.AppointmentRepository;
import com.myproject.hospitalaplication.repository.PatientRespository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientService patientService;
    private final AppointmentDtoConverter appointmentDtoConverter;
    private final PatientRespository patientRespository;

    public AppointmentService(AppointmentDtoConverter appointmentDtoConverter, AppointmentRepository appointmentRepository, PatientService patientService,
                              PatientRespository patientRespository) {
        this.appointmentRepository = appointmentRepository;
        this.patientService = patientService;
        this.appointmentDtoConverter = appointmentDtoConverter;
        this.patientRespository = patientRespository;
    }


    public AppointmentDto createAppointment(CreateAppointmentRequest createAppointmentRequest) {
        Appointment appointment = new Appointment();
        appointment.setId(createAppointmentRequest.getId());
        appointment.setDate(createAppointmentRequest.getDate());
        appointment.setHour(createAppointmentRequest.getHour());
        appointment.setNotes(appointment.getNotes());
        appointment.setMinute(createAppointmentRequest.getMinute());
        appointment.setDocktorId(createAppointmentRequest.getDocktorId());
        appointment.setPatientId(createAppointmentRequest.getPatientId());
        appointmentRepository.save(appointment);
        return AppointmentDtoConverter.convert(appointment);
    }

    public AppointmentDto updateAppointment(int id, UpdateAppointmentRequest updateAppointmentRequest) {
        Patient patient=patientService.getPatientById(updateAppointmentRequest.getPatientId());
        if(patient.getId().equals("")|| patient.getId()==null){
            return AppointmentDto.builder().build();}

        Optional<Appointment> appointmentOptional=appointmentRepository.findById(id);
        appointmentOptional.ifPresent(appointment -> {
            appointment.setDate(updateAppointmentRequest.getDate());
            appointment.setDocktorId(updateAppointmentRequest.getDocktorId());
            appointment.setHour(updateAppointmentRequest.getHour());
            appointment.setNotes(updateAppointmentRequest.getNotes());
            appointment.setMinute(updateAppointmentRequest.getMinute());
        });
           return appointmentOptional.map(appointment -> AppointmentDtoConverter.convert(appointment)).orElse(new AppointmentDto());
    }

    public List<AppointmentDto> getAllAppointment() {
        List<Appointment> appointmentList= appointmentRepository.findAll();

      return  appointmentList.stream().map(appointment -> AppointmentDtoConverter.convert(appointment)).collect(Collectors.toList());

    }
    public AppointmentDto getAppointmentById(int id) {
       Optional <Appointment> appointmentOptional=appointmentRepository.findById(id);

      return appointmentOptional.map(appointment -> AppointmentDtoConverter.convert(appointment)).orElse(new AppointmentDto());

    }

    public void getAppointmentDeleteById(int id) {
        appointmentRepository.deleteById(id);
    }


}
