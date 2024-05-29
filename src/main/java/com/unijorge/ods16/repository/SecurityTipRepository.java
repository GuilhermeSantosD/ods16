package com.unijorge.ods16.repository;

import com.unijorge.ods16.model.SecurityTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityTipRepository extends JpaRepository<SecurityTip,Long> {
}
