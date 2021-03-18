package com.softwareplant.starwarsreport.repositories;

import com.softwareplant.starwarsreport.model.ReportResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportResultRepository extends JpaRepository<ReportResult, Long> {

    void deleteById(Long id);

    void deleteAll();

    Optional<ReportResult> findById(Long id);

    List<ReportResult> findAll();
}
