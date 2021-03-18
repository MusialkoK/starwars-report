package com.softwareplant.starwarsreport.controllers;

import com.softwareplant.starwarsreport.factories.ReportFactory;
import com.softwareplant.starwarsreport.factories.ReportResponseFactory;
import com.softwareplant.starwarsreport.model.Report;
import com.softwareplant.starwarsreport.model.rest.ReportQuery;
import com.softwareplant.starwarsreport.model.rest.ReportResponse;
import com.softwareplant.starwarsreport.services.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reports")
@AllArgsConstructor
public class ReportController {

    private final ReportFactory reportFactory;
    private final ReportResponseFactory reportResponseFactory;
    private final ReportService reportService;

    @PutMapping("/{id}")
    public ResponseEntity<ReportResponse> putReport(@PathVariable Long id, @RequestBody ReportQuery query) {
        try {
            reportService.save(reportFactory.create(id, query));
                return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReportResponse> deleteReport(@PathVariable Long id) {
        try {
            reportService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping()
    public ResponseEntity<ReportResponse> deleteReports() {
        try {
            reportService.deleteAll();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ReportResponse> getReport(@PathVariable Long id) {
        try {
            Report report = reportService.findById(id);
            ReportResponse response = reportResponseFactory.create(report);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping()
    @ResponseBody
    public ResponseEntity<List<ReportResponse>> getReports() {
        try {
            List<Report> reports = reportService.findAll();
            List<ReportResponse> body = reports.stream()
                    .map(reportResponseFactory::create)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(body);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
