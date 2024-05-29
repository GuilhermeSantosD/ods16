package com.unijorge.ods16.repository;

import com.unijorge.ods16.model.SecurityPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityPostRepository extends JpaRepository<SecurityPost,Long> {
}
