package com.unijorge.ods16.controller;


import com.unijorge.ods16.model.Report;
import com.unijorge.ods16.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
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


}
