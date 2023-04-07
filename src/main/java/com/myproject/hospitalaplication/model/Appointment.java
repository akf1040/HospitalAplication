package com.myproject.hospitalaplication.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {
    @Id
    @GeneratedValue
    private int id;
    private String docktorId;
    private String patientId;
    private String date;
    private String notes;
    private int hour;
    private int minute;
}
