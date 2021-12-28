package com.service.weather;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLData;

/**
 * Main class where spring boot application starts.
 *
 * @author Vishnu
 * @version 1.0
 * @since 2021-12-27
 */
@SpringBootApplication
public class WeatherServiceApplication {
    private static final Logger logger = LogManager.getLogger(WeatherServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WeatherServiceApplication.class, args);
        SQLData sqlData;
        logger.info("<<<----- Weather service application is started ----->>>");
    }

}
