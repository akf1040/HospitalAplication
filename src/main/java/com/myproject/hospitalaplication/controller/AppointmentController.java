package com.myproject.hospitalaplication.controller;

import com.myproject.hospitalaplication.dto.AppointmentDto;
import com.myproject.hospitalaplication.dto.CreateAppointmentRequest;
import com.myproject.hospitalaplication.dto.UpdateAppointmentRequest;
import com.myproject.hospitalaplication.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody CreateAppointmentRequest createAppointmentRequest) {
        return ResponseEntity.ok(appointmentService.createAppointment(createAppointmentRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDto> updateAppointment(@PathVariable int id, @RequestBody UpdateAppointmentRequest updateAppointmentRequest) {
        return ResponseEntity.ok(appointmentService.updateAppointment(id, updateAppointmentRequest));
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAllAppointment() {
        return ResponseEntity.ok(appointmentService.getAllAppointment());

    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable int id) {
        return ResponseEntity.ok(appointmentService.getAppointmentById(id));
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void> getAppointmentDeleteById(@PathVariable int id) {
        appointmentService.getAppointmentDeleteById(id);
        return ResponseEntity.ok().build();
    }
}