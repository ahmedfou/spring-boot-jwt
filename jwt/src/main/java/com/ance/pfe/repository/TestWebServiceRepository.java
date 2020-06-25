package com.ance.pfe.repository;

import com.ance.pfe.domain.TestWebService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestWebServiceRepository extends JpaRepository<TestWebService, Long> {
}
