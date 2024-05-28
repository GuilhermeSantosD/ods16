package com.unijorge.ods16.repository;

import com.unijorge.ods16.model.Case;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRepository extends JpaRepository<Case, Long> {
}
