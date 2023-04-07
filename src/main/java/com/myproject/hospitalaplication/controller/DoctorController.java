package com.myproject.hospitalaplication.controller;


import com.myproject.hospitalaplication.dto.CreateDoctorRequest;
import com.myproject.hospitalaplication.dto.DoctorDto;
import com.myproject.hospitalaplication.dto.UpdateDoctorRequest;
import com.myproject.hospitalaplication.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/doctors")
public class DoctorController {
    private final DoctorService doctorService;
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }



    @PostMapping()
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody CreateDoctorRequest createDoctorRequest){
        return ResponseEntity.ok(doctorService.createDoctor(createDoctorRequest));
    }
    @PutMapping("/{id}")
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable String id,@RequestBody UpdateDoctorRequest updateDoctorRequest){
        return ResponseEntity.ok(doctorService.updateDoctor(id,updateDoctorRequest));
    }

    @GetMapping()
    public ResponseEntity<List<DoctorDto>> getAllDoctor(){
        return ResponseEntity.ok(doctorService.getAllDoctor());
    }
    @GetMapping("/{id}")
        public ResponseEntity<DoctorDto> getDoctorById(@PathVariable String id){
            return ResponseEntity.ok(doctorService.getDoctorById(id));

        }
        @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable String id){
        doctorService.deleteDoctor(id);
      return   ResponseEntity.ok().build();
        }
    }

