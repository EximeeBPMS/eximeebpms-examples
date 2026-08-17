#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.util.Arrays;
import java.sql.SQLException;

import org.eximeebpms.bpm.engine.ProcessEngine;
import org.eximeebpms.bpm.engine.runtime.ProcessInstance;
import org.eximeebpms.bpm.engine.test.Deployment;
import org.eximeebpms.bpm.engine.variable.Variables;
import org.eximeebpms.bpm.engine.variable.Variables.SerializationDataFormats;
import org.eximeebpms.bpm.engine.variable.value.ObjectValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.eximeebpms.bpm.engine.test.assertions.ProcessEngineTests.*;
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
  public void testHappyPath() throws SQLException {
    // Drive the process by API and assert correct behavior by eximeebpms-bpm-assert

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

    // To inspect the DB connect your browser to: http://localhost:8080/h2-console/

  }

}
