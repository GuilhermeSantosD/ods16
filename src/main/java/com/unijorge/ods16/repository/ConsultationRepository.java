package com.unijorge.ods16.repository;

import com.unijorge.ods16.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository  extends JpaRepository<Consultation, Long> {
}
