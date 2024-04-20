package com.shadatrahman.runnerz;

import com.shadatrahman.runnerz.run.Location;
import com.shadatrahman.runnerz.run.Run;
import com.shadatrahman.runnerz.run.RunJsonDataLoader;
import com.shadatrahman.runnerz.run.RunRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class RunnerzApplication {

    private static final Logger log = LoggerFactory.getLogger(RunnerzApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RunnerzApplication.class, args);
        log.info("Application started");
    }
}
