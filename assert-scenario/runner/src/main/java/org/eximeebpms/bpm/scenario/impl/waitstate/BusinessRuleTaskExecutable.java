package org.eximeebpms.bpm.scenario.impl.waitstate;


import org.eximeebpms.bpm.engine.history.HistoricActivityInstance;
import org.eximeebpms.bpm.scenario.ProcessScenario;
import org.eximeebpms.bpm.scenario.act.Action;
import org.eximeebpms.bpm.scenario.impl.ProcessRunnerImpl;

import java.util.Map;

/**
 * @author Martin Schimak
 */
public class BusinessRuleTaskExecutable extends ServiceTaskExecutable {

  public BusinessRuleTaskExecutable(ProcessRunnerImpl runner, HistoricActivityInstance instance) {
    super(runner, instance);
  }

  @Override
  protected Action action(ProcessScenario scenario) {
    return scenario.waitsAtBusinessRuleTask(getActivityId());
  }

  @Override
  public void complete() {
    super.complete();
  }

  @Override
  public void complete(Map<String, Object> variables) {
    super.complete(variables);
  }

  @Override
  public void handleBpmnError(String errorCode) {
    super.handleBpmnError(errorCode);
  }

  @Override
  public void handleBpmnError(String errorCode, Map<String, Object> variables) {
    super.handleBpmnError(errorCode, variables);
  }

}
