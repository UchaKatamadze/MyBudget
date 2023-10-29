package com.example.myBudget;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: Ucha Katamadze
 * This class is the main class for the application. It is responsible for starting the application.
 * It also contains the main method.
 * Added log information and error handling.
 */
@SpringBootApplication
public class PersonalFinanceApplication {

    private static final Logger log = LoggerFactory.getLogger(PersonalFinanceApplication.class);

    public static void main(String[] args) {
        try {
            log.info("Starting Personal Finance Application");
            SpringApplication.run(PersonalFinanceApplication.class, args);
            log.info("Personal Finance Application Started");
        } catch (Exception e) {
            log.error("Error starting Personal Finance Application", e);
        }
    }
}
