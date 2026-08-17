package org.eximeebpms.bpm.scenario.impl.waitstate;

import org.eximeebpms.bpm.engine.history.HistoricActivityInstance;
import org.eximeebpms.bpm.engine.task.Task;
import org.eximeebpms.bpm.scenario.ProcessScenario;
import org.eximeebpms.bpm.scenario.act.Action;
import org.eximeebpms.bpm.scenario.impl.ProcessRunnerImpl;
import org.eximeebpms.bpm.scenario.impl.delegate.AbstractTaskDelegate;

import java.util.Map;

/**
 * @author Martin Schimak
 */
public class UserTaskExecutable extends AbstractTaskDelegate {

  public UserTaskExecutable(ProcessRunnerImpl runner, HistoricActivityInstance instance) {
    super(runner, instance);
  }

  @Override
  protected Task getDelegate() {
    return getTaskService().createTaskQuery().activityInstanceIdIn(historicDelegate.getId()).singleResult();
  }

  @Override
  protected Action<?> action(ProcessScenario scenario) {
    return scenario.waitsAtUserTask(getActivityId());
  }

  @Override
  public void complete() {
    getTaskService().complete(getDelegate().getId());
  }

  @Override
  public void complete(Map<String, Object> variables) {
    getTaskService().complete(getDelegate().getId(), variables);
  }

  @Override
  public void handleBpmnError(String errorCode) {
    getTaskService().handleBpmnError(getDelegate().getId(), errorCode);
  }

  @Override
  public void handleBpmnError(String errorCode, Map<String, Object> variables) {
    getTaskService().handleBpmnError(getDelegate().getId(), errorCode, null, variables);
  }

  @Override
  public void handleEscalation(String escalationCode) {
    getTaskService().handleEscalation(getDelegate().getId(), escalationCode);
  }

  @Override
  public void handleEscalation(String escalationCode, Map<String, Object> variables) {
    getTaskService().handleEscalation(getDelegate().getId(), escalationCode, variables);
  }

}
