package com.unijorge.ods16.repository;

import com.unijorge.ods16.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
