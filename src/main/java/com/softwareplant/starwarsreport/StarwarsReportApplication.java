
package com.softwareplant.starwarsreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class StarwarsReportApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarwarsReportApplication.class, args);
    }

}
