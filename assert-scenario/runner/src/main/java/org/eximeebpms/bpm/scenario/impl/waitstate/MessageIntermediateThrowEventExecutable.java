package org.eximeebpms.bpm.scenario.impl.waitstate;


import org.eximeebpms.bpm.engine.history.HistoricActivityInstance;
import org.eximeebpms.bpm.scenario.ProcessScenario;
import org.eximeebpms.bpm.scenario.act.Action;
import org.eximeebpms.bpm.scenario.delegate.ExternalTaskDelegate;
import org.eximeebpms.bpm.scenario.impl.ProcessRunnerImpl;

import java.util.Map;

/**
 * @author Martin Schimak
 */
public class MessageIntermediateThrowEventExecutable extends ServiceTaskExecutable {

  public MessageIntermediateThrowEventExecutable(ProcessRunnerImpl runner, HistoricActivityInstance instance) {
    super(runner, instance);
  }

  @Override
  protected Action<ExternalTaskDelegate> action(ProcessScenario scenario) {
    return scenario.waitsAtMessageIntermediateThrowEvent(getActivityId());
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
