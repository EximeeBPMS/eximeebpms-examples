package org.example.eximeebpms.bpm;

import org.eximeebpms.bpm.engine.ProcessEngine;
import org.eximeebpms.bpm.engine.runtime.ProcessInstance;
import org.eximeebpms.bpm.engine.test.Deployment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.eximeebpms.bpm.scenario.ProcessScenario;
import org.eximeebpms.bpm.scenario.Scenario;
import org.eximeebpms.bpm.scenario.run.ProcessRunner.ExecutableRunner;

import static org.mockito.Mockito.*;

import static org.assertj.core.api.Assertions.*;
import static org.eximeebpms.bpm.engine.test.assertions.bpmn.BpmnAwareTests.*;


/**
 * Test case starting an in-memory database-backed Process Engine.
 */
// Camunda Community Hub's process-test-coverage extension doesn't work against
// the renamed engine (its published jar hardcodes org.camunda.bpm.engine.* class
// names) - the @Import of its Spring config was dropped; the Spring Boot
// starter already auto-configures the ProcessEngine bean autowired below.
@SpringBootTest
public class ProcessScenarioTest {

  @Autowired
  private ProcessEngine processEngine;

  @BeforeEach
  public void setup() {
    init(processEngine);
    MockitoAnnotations.openMocks(this);
  }

  @Mock
  private ProcessScenario myProcess;

  @Test
  @Deployment(resources="process.bpmn")
  public void testHappyPath() {
    // Define scenarios by using eximeebpms-bpm-assert-scenario:

    //ExecutableRunner starter = Scenario.run(myProcess) //
    //    .startByKey(ProcessConstants.PROCESS_DEFINITION_KEY);

    // when(myProcess.waitsAtReceiveTask(anyString())).thenReturn((messageSubscription) -> {
    //  messageSubscription.receive();
    // });
    // when(myProcess.waitsAtUserTask(anyString())).thenReturn((task) -> {
    //  task.complete();
    // });

    // OK - everything prepared - let's go and execute the scenario
    //Scenario scenario = starter.execute();

    // now you can do some assertions   
    //verify(myProcess).hasFinished("EndEvent");
  }

}
