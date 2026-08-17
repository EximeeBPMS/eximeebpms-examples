package ${package};

import org.eximeebpms.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication("${artifactId}")
public class EximeeBpmsApplication {

  public static void main(String... args) {
    SpringApplication.run(EximeeBpmsApplication.class, args);
  }

}
