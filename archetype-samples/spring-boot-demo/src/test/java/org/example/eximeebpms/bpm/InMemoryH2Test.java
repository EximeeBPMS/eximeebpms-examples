package org.example.eximeebpms.bpm;

import java.util.Arrays;
import java.sql.SQLException;

import org.eximeebpms.bpm.engine.runtime.ProcessInstance;
import org.eximeebpms.bpm.engine.test.Deployment;
import org.eximeebpms.bpm.engine.test.mock.Mocks;
import org.eximeebpms.bpm.engine.variable.Variables;
import org.eximeebpms.bpm.engine.variable.Variables.SerializationDataFormats;
import org.eximeebpms.bpm.engine.variable.value.ObjectValue;
import org.eximeebpms.bpm.engine.test.junit5.ProcessEngineExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.eximeebpms.bpm.engine.test.assertions.ProcessEngineTests.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Test case starting an in-memory database-backed Process Engine.
 */
// Camunda Community Hub's process-test-coverage extension doesn't work against
// the renamed engine (its published jar hardcodes org.camunda.bpm.engine.* class
// names) - using the plain extension instead of the coverage-reporting one.
@ExtendWith(ProcessEngineExtension.class)
public class InMemoryH2Test {

  @Test
  @Deployment(resources = "process.bpmn")
  public void testHappyPath() throws SQLException {
    // Drive the process by API and assert correct behavior by eximeebpms-bpm-assert

    Mocks.register("logger", new LoggerDelegate());

    ObjectValue documents = Variables
      .objectValue(Arrays.asList(new String[]{"one", "two", "three"}))
      .serializationDataFormat(SerializationDataFormats.JSON)
      .create();

    ProcessInstance processInstance = runtimeService()
        .createProcessInstanceByKey(ProcessConstants.PROCESS_DEFINITION_KEY)
        .businessKey("23")
        .setVariable("documents", documents)
        .execute();

    assertThat(processInstance).isWaitingAt("UserTask_Approve");

    // To inspect the DB, run the following line in the debugger
    // then connect your browser to: http://localhost:8082
    // and enter the JDBC URL: jdbc:h2:mem:eximeebpms
//    org.h2.tools.Server.createWebServer("-web").start();

  }

}
