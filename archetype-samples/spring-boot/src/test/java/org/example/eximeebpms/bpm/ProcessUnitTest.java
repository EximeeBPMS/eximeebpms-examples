package org.example.eximeebpms.bpm;

import org.eximeebpms.bpm.engine.ProcessEngine;
import org.eximeebpms.bpm.engine.runtime.ProcessInstance;
import org.eximeebpms.bpm.engine.test.Deployment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.eximeebpms.bpm.engine.test.assertions.bpmn.BpmnAwareTests.*;
import static org.assertj.core.api.Assertions.*;


/**
 * Test case starting an in-memory database-backed Process Engine.
 */
// Camunda Community Hub's process-test-coverage extension doesn't work against
// the renamed engine (its published jar hardcodes org.camunda.bpm.engine.* class
// names) - the @Import of its Spring config was dropped; the Spring Boot
// starter already auto-configures the ProcessEngine bean autowired below.
@SpringBootTest
public class ProcessUnitTest {

  @Autowired
  private ProcessEngine processEngine;

  @BeforeEach
  public void setup() {
    init(processEngine);
  }

  @Test
  @Deployment(resources = "process.bpmn")
  public void testHappyPath() {
    // Drive the process by API and assert correct behavior by eximeebpms-bpm-assert

    ProcessInstance processInstance = processEngine().getRuntimeService()
        .startProcessInstanceByKey(ProcessConstants.PROCESS_DEFINITION_KEY);

    assertThat(processInstance).isEnded();

  }

}
