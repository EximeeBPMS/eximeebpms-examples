package org.example.eximeebpms.bpm;

import org.eximeebpms.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication("eximeebpms-process-application")
public class EximeeBpmsApplication {

  public static void main(String... args) {
    SpringApplication.run(EximeeBpmsApplication.class, args);
  }

}
