package com.softwareplant.starwarsreport.services;

import com.softwareplant.starwarsreport.model.Report;
import com.softwareplant.starwarsreport.repositories.ReportRepository;
import com.softwareplant.starwarsreport.repositories.ReportResultRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;
    private final ReportResultRepository reportResultRepository;

    public Report save(Report report) {
        return reportRepository.save(report);
    }

    public void deleteById(Long id) {
        reportRepository.deleteById(id);
    }

    public void deleteAll() {
        reportRepository.deleteAll();
    }

    public Report findById(Long id) {
        return reportRepository.findById(id).orElseThrow();
    }

    public List<Report> findAll() {
        return reportRepository.findAll();
    }
}
