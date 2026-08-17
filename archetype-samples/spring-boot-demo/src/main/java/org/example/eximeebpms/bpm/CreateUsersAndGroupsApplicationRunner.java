package org.example.eximeebpms.bpm;

import org.eximeebpms.bpm.engine.ProcessEngine;
import org.eximeebpms.bpm.spring.boot.starter.SpringBootProcessApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

// The original demo user/group/filter setup used third-party demo
// utilities (FilterGenerator, UserGenerator, DemoDataGenerator) whose
// own method signatures take the pre-rename org.camunda.bpm.engine.
// ProcessEngine, which no longer exists on the classpath (only the
// renamed eximeebpms-engine does) - so calling them here doesn't
// compile. Left as a no-op for now.
@Component
public class CreateUsersAndGroupsApplicationRunner implements ApplicationRunner {

  @Autowired
  private ProcessEngine processEngine;

  @Autowired
  private SpringBootProcessApplication processApplication;

  @Override
  public void run(ApplicationArguments args) throws Exception {
  }

}
