package com.starkye.project_deliver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ProjectDeliverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectDeliverApplication.class, args);
        log.info("Project Start Successful...");
    }

}
