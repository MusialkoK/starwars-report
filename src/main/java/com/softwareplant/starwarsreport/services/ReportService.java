package com.softwareplant.starwarsreport.services;

import com.softwareplant.starwarsreport.model.Report;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    public Report save(Report report){
        return report;
    }

    public void deleteById(Long id) {
    }

    public void deleteAll() {
    }

    public Report findById(Long id) {
        return new Report();
    }

    public List<Report> findAll() {
        return Collections.emptyList();
    }
}
