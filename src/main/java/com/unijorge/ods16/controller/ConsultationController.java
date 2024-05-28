package com.unijorge.ods16.controller;

import com.unijorge.ods16.model.Consultation;
import com.unijorge.ods16.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultations")
public class ConsultationController {
    @Autowired
    private ConsultationService consultationService;

    @PostMapping("/create")
    public Consultation createConsultation(@RequestBody Consultation consultation) {
        return consultationService.saveConsultation(consultation);
    }
    @GetMapping("/list")
    public List<Consultation> getAllConsultations() {
        return consultationService.getAllConsultations();
    }

    @GetMapping("/list/{id}")
    public Consultation getConsultation(@PathVariable Long id) {
        return consultationService.getConsultationById(id);
    }

}