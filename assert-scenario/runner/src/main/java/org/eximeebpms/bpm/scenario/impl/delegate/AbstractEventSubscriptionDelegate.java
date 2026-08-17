package org.eximeebpms.bpm.scenario.impl.delegate;

import org.eximeebpms.bpm.engine.history.HistoricActivityInstance;
import org.eximeebpms.bpm.engine.runtime.EventSubscription;
import org.eximeebpms.bpm.scenario.delegate.EventSubscriptionDelegate;
import org.eximeebpms.bpm.scenario.impl.ProcessRunnerImpl;
import org.eximeebpms.bpm.scenario.impl.WaitstateExecutable;

import java.util.Date;

/**
 * @author Martin Schimak
 */
public abstract class AbstractEventSubscriptionDelegate extends WaitstateExecutable<EventSubscription> implements EventSubscriptionDelegate {

  public AbstractEventSubscriptionDelegate(ProcessRunnerImpl runner, HistoricActivityInstance instance) {
    super(runner, instance);
  }

  public String getId() {
    return delegate.getId();
  }

  public String getEventType() {
    return delegate.getEventType();
  }

  public String getEventName() {
    return delegate.getEventName();
  }

  public String getProcessInstanceId() {
    return delegate.getProcessInstanceId();
  }

  public String getTenantId() {
    return delegate.getTenantId();
  }

  public Date getCreated() {
    return delegate.getCreated();
  }

}
