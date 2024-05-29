package com.unijorge.ods16.service;

import com.unijorge.ods16.model.Report;
import com.unijorge.ods16.model.User;
import com.unijorge.ods16.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public Report saveReport(Report report) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));

        if (!isAdmin) {
            report.setStatus("Pendente");
        }

        report.setSubmissionDate(LocalDateTime.now());

        if (!report.isAnonymous()) {
            report.setUser((User) authentication.getPrincipal());
        } else {
            report.setUser(null);
        }

        return reportRepository.save(report);
    }

    public Report getReportById(Long id) {
        return reportRepository.findById(id).orElse(null);
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Report updateReport(Long id, Report report) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));

        Report existingReport = reportRepository.findById(id).orElse(null);
        if (existingReport != null) {
            existingReport.setTitle(report.getTitle());
            existingReport.setDescription(report.getDescription());
            if (isAdmin) {
                existingReport.setStatus(report.getStatus());
            }
            return reportRepository.save(existingReport);
        }
        return null;
    }

    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }
}
