package com.myproject.hospitalaplication.dto;

import com.myproject.hospitalaplication.model.Appointment;
import org.springframework.stereotype.Component;


@Component
public class AppointmentDtoConverter {

    public static AppointmentDto convert(Appointment appointment) {
        AppointmentDto appointmentDto = AppointmentDto.builder()
                .id(appointment.getId())
                .date(appointment.getDate())
                .docktorId(appointment.getDocktorId())
                .hour(appointment.getHour())
                .minute(appointment.getMinute())
                .notes(appointment.getNotes())
                .patientId(appointment.getPatientId())
                .build();
        return appointmentDto;
    }

}
