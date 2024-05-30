package com.unijorge.ods16.controller;

import com.unijorge.ods16.model.Report;
import com.unijorge.ods16.model.Sos;
import com.unijorge.ods16.service.SosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sos")
@CrossOrigin(origins = "http://localhost:3000")
public class SosController {

    @Autowired
    private SosService sosService;

    @GetMapping("/list")
    public List<Sos> getAll() {
        return sosService.getAllSos();
    }

    @PostMapping("/create")
    public Sos addSos(@RequestBody Sos sos) {
        return sosService.saveSos(sos);
    }
    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Sos updateReport(@PathVariable Long id, @RequestBody Sos sos) {
        return sosService.updateSos(id, sos);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteReport(@PathVariable Long id) {
        sosService.deleteSos(id);
    }

}
