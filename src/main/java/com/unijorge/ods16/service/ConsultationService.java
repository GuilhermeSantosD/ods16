package com.unijorge.ods16.service;

import com.unijorge.ods16.model.Consultation;
import com.unijorge.ods16.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService {
    @Autowired
    private ConsultationRepository consultationRepository;

    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    public Consultation getConsultationById(Long id) {
        return consultationRepository.findById(id).orElse(null);
    }

    public List<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }
    public Consultation createOrUpdate(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    public void deleteConsulation(Long id) {
        consultationRepository.deleteById(id);
    }

}
