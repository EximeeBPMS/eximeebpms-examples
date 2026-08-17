package org.eximeebpms.bpm.scenario.impl.delegate;

import org.eximeebpms.bpm.engine.history.HistoricActivityInstance;
import org.eximeebpms.bpm.engine.runtime.ProcessInstance;
import org.eximeebpms.bpm.scenario.delegate.ProcessInstanceDelegate;
import org.eximeebpms.bpm.scenario.impl.ProcessRunnerImpl;
import org.eximeebpms.bpm.scenario.impl.WaitstateExecutable;

/**
 * @author Martin Schimak
 */
public abstract class AbstractProcessInstanceDelegate extends WaitstateExecutable<ProcessInstance> implements ProcessInstanceDelegate {

  public AbstractProcessInstanceDelegate(ProcessRunnerImpl runner, HistoricActivityInstance instance) {
    super(runner, instance);
  }

  public String getProcessDefinitionId() {
    return delegate.getProcessDefinitionId();
  }

  public String getProcessDefinitionKey() {
    return delegate.getProcessDefinitionKey();
  }

  public String getBusinessKey() {
    return delegate.getBusinessKey();
  }

  public String getCaseInstanceId() {
    return delegate.getCaseInstanceId();
  }

  public boolean isSuspended() {
    return delegate.isSuspended();
  }

  public String getId() {
    return delegate.getId();
  }

  public boolean isEnded() {
    return delegate.isEnded();
  }

  public String getProcessInstanceId() {
    return delegate.getProcessInstanceId();
  }

  public String getTenantId() {
    return delegate.getTenantId();
  }

}
