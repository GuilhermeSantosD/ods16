package com.unijorge.ods16.service;

import com.unijorge.ods16.model.Case;
import com.unijorge.ods16.repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseService {

  @Autowired
  private CaseRepository caseRepository;

    public Case saveCase(Case denucia) {
        return caseRepository.save(denucia);
    }

    public Case getCaseById(Long id) {
        return caseRepository.findById(id).orElse(null);
    }

    public List<Case> getAllCases() {
        return caseRepository.findAll();
    }
}
