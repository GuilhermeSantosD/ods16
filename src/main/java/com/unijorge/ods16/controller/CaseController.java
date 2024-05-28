package com.unijorge.ods16.controller;

import com.unijorge.ods16.model.Case;
import com.unijorge.ods16.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cases")
public class CaseController {
    @Autowired
    private CaseService caseService;

    @PostMapping("/create")
    public Case createCase(@RequestBody Case denuncia) {
        return caseService.saveCase(denuncia);
    }

    @GetMapping("/list")
    public List<Case> getAllCases() {
        return caseService.getAllCases();
    }

    @GetMapping("/list/{id}")
    public Case getCase(@PathVariable Long id) {
        return caseService.getCaseById(id);
    }

}