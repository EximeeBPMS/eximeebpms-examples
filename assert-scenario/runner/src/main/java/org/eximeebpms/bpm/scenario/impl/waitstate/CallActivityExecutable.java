package org.eximeebpms.bpm.scenario.impl.waitstate;

import org.eximeebpms.bpm.engine.history.HistoricActivityInstance;
import org.eximeebpms.bpm.engine.runtime.ProcessInstance;
import org.eximeebpms.bpm.scenario.ProcessScenario;
import org.eximeebpms.bpm.scenario.act.Action;
import org.eximeebpms.bpm.scenario.act.MockedCallActivityAction;
import org.eximeebpms.bpm.scenario.delegate.ProcessInstanceDelegate;
import org.eximeebpms.bpm.scenario.impl.MockedProcessRunnerImpl;
import org.eximeebpms.bpm.scenario.impl.ProcessRunnerImpl;
import org.eximeebpms.bpm.scenario.impl.delegate.AbstractProcessInstanceDelegate;

/**
 * @author Martin Schimak
 */
public class CallActivityExecutable extends AbstractProcessInstanceDelegate {

  public CallActivityExecutable(ProcessRunnerImpl runner, HistoricActivityInstance instance) {
    super(runner, instance);
  }

  @Override
  protected ProcessInstance getDelegate() {
    return getRuntimeService().createProcessInstanceQuery().processInstanceId(historicDelegate.getCalledProcessInstanceId()).singleResult();
  }

  @Override
  protected Action<ProcessInstanceDelegate> action(final ProcessScenario scenario) {
    final ProcessRunnerImpl mocked = (ProcessRunnerImpl) scenario.runsCallActivity(getActivityId());
    final MockedCallActivityAction action = scenario.waitsAtMockedCallActivity(getActivityId());
    final ProcessRunnerImpl runner = mocked != null ? mocked : (action != null ? new MockedProcessRunnerImpl(action) : null);
    if (runner != null) {
      return new Action<ProcessInstanceDelegate>() {
        @Override
        public void execute(ProcessInstanceDelegate processInstance) {
          runner.running((CallActivityExecutable) processInstance);
        }
      };
    }
    return null;
  }

  @Override
  public String getRootProcessInstanceId() {
    return getProcessInstance().getRootProcessInstanceId();
  }
}
