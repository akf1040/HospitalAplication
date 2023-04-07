package com.myproject.hospitalaplication.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAppointmentRequest {
    private int id;
    private String docktorId;
    private String patientId;
    private String date;
    private String notes;
    private int hour;
    private int minute;
}
