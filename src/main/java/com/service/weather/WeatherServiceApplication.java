package com.service.weather;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.sql.SQLData;

/**
 * Main class where spring boot application starts.
 *
 * @author Vishnu
 * @version 1.0
 * @since 2021-12-27
 */
@SpringBootApplication
@EnableCaching
public class WeatherServiceApplication {
    private static final Logger logger = LoggerFactory.getLogger(WeatherServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WeatherServiceApplication.class, args);
        SQLData sqlData;
        logger.info("<<<----- Weather service application is started ----->>>");
    }

}
