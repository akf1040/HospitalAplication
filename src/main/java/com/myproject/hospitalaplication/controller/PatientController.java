package com.myproject.hospitalaplication.controller;


import com.myproject.hospitalaplication.dto.CreatePatientRequest;
import com.myproject.hospitalaplication.dto.PatientDto;
import com.myproject.hospitalaplication.dto.UpdatePatientRequest;
import com.myproject.hospitalaplication.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/patients")
public class PatientController {
    private final PatientService patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @PostMapping()
    public ResponseEntity<PatientDto> createPatient(@RequestBody CreatePatientRequest createPatientRequest){
        return ResponseEntity.ok(patientService.createPatient(createPatientRequest));

    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable String id,@RequestBody UpdatePatientRequest updatePatientRequest){
        return ResponseEntity.ok(patientService.updatePatient(id,updatePatientRequest));
    }
    @GetMapping()
    public ResponseEntity<List<PatientDto>> getAllPatient(){
        return ResponseEntity.ok(patientService.getAllPatient());

    }
    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getPatientDtoById(@PathVariable String id){
        return ResponseEntity.ok(patientService.getPatientDtoById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<PatientDto>> deletePatient(@PathVariable String id){
        patientService. deletePatient(id);
        return  ResponseEntity.ok().build();
    }
}
