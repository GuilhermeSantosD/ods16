package com.unijorge.ods16.controller;


import com.unijorge.ods16.model.Report;
import com.unijorge.ods16.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "http://localhost:3000")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @PostMapping("/create")
    public Report createReport(@RequestBody Report report) {
        return reportService.saveReport(report);
    }

    @GetMapping("/list")
    public List<Report> getReport(Report report) {
        return reportService.getAllReports();
    }

    @GetMapping("/list/{id}")
    public Report getReport(@PathVariable Long id) {
        return reportService.getReportById(id);
    }


    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Report updateReport(@PathVariable Long id, @RequestBody Report report) {
        return reportService.updateReport(id, report);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteReport(@PathVariable Long id) {
        reportService.deleteReport(id);
    }

}
