package com.softwareplant.starwarsreport.repositories;

import com.softwareplant.starwarsreport.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    Report save(Report report);
    void deleteById(Long id);
    void deleteAll();
    Optional<Report> findById(Long id);
    List<Report> findAll();


}
