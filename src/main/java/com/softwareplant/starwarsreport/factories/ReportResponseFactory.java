package com.softwareplant.starwarsreport.factories;

import com.softwareplant.starwarsreport.model.Report;
import com.softwareplant.starwarsreport.model.rest.ReportResponse;
import org.springframework.stereotype.Service;

@Service
public class ReportResponseFactory {

    public ReportResponse create(Report report){
        return new ReportResponse();
    }

}
