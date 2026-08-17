package org.eximeebpms.bpm.scenario.impl.waitstate;


import org.eximeebpms.bpm.engine.history.HistoricActivityInstance;
import org.eximeebpms.bpm.engine.runtime.ProcessInstance;
import org.eximeebpms.bpm.scenario.ProcessScenario;
import org.eximeebpms.bpm.scenario.act.Action;
import org.eximeebpms.bpm.scenario.impl.ProcessRunnerImpl;
import org.eximeebpms.bpm.scenario.impl.delegate.AbstractProcessInstanceDelegate;
import org.eximeebpms.bpm.scenario.impl.util.Log;
import org.eximeebpms.bpm.scenario.impl.util.Time;

/**
 * @author Martin Schimak
 */
public class ConditionalIntermediateEventExecutable extends AbstractProcessInstanceDelegate {

  public ConditionalIntermediateEventExecutable(ProcessRunnerImpl runner, HistoricActivityInstance instance) {
    super(runner, instance);
  }

  @Override
  protected ProcessInstance getDelegate() {
    return getRuntimeService().createProcessInstanceQuery().processInstanceId(getProcessInstance().getId()).singleResult();
  }

  @Override
  protected Action action(ProcessScenario scenario) {
    return scenario.waitsAtConditionalIntermediateEvent(getActivityId());
  }

  public void execute() {
    Action action = action();
    Time.set(isExecutableAt());
    try {
      if (action != null) {
        Log.Action.ActingOn.log(
          historicDelegate.getActivityType(),
          historicDelegate.getActivityName(),
          historicDelegate.getActivityId(),
          runner.getProcessDefinitionKey(),
          historicDelegate.getProcessInstanceId(),
          null,
          null
        );
        action.execute(this);
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    runner.setExecuted(this);
  }

  @Override
  public String getRootProcessInstanceId() {
    return getProcessInstance().getRootProcessInstanceId();
  }
}
