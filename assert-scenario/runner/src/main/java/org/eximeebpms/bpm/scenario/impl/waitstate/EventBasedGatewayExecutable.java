package org.eximeebpms.bpm.scenario.impl.waitstate;


import org.eximeebpms.bpm.engine.history.HistoricActivityInstance;
import org.eximeebpms.bpm.engine.runtime.EventSubscription;
import org.eximeebpms.bpm.scenario.ProcessScenario;
import org.eximeebpms.bpm.scenario.act.Action;
import org.eximeebpms.bpm.scenario.delegate.EventBasedGatewayDelegate;
import org.eximeebpms.bpm.scenario.delegate.EventSubscriptionDelegate;
import org.eximeebpms.bpm.scenario.impl.ProcessRunnerImpl;
import org.eximeebpms.bpm.scenario.impl.WaitstateExecutable;
import org.eximeebpms.bpm.scenario.impl.delegate.EventSubscriptionDelegateImpl;

import java.util.List;

/**
 * @author Martin Schimak
 */
public class EventBasedGatewayExecutable extends WaitstateExecutable<EventBasedGatewayDelegate> implements EventBasedGatewayDelegate {

  public EventBasedGatewayExecutable(ProcessRunnerImpl runner, HistoricActivityInstance instance) {
    super(runner, instance);
  }

  @Override
  protected EventBasedGatewayDelegate getDelegate() {
    return null;
  }

  @Override
  protected Action<EventBasedGatewayDelegate> action(ProcessScenario scenario) {
    return scenario.waitsAtEventBasedGateway(getActivityId());
  }

  @Override
  public List<EventSubscriptionDelegate> getEventSubscriptions() {
    List<EventSubscription> eventSubscriptions = getRuntimeService().createEventSubscriptionQuery().executionId(getExecutionId()).list();
    return EventSubscriptionDelegateImpl.newInstance(this, eventSubscriptions);
  }

  @Override
  public EventSubscriptionDelegate getEventSubscription(String activityId) {
    return EventSubscriptionDelegateImpl.newInstance(this, getRuntimeService().createEventSubscriptionQuery().activityId(activityId).executionId(getExecutionId()).singleResult());
  }

  @Override
  public EventSubscriptionDelegate getEventSubscription() {
    return EventSubscriptionDelegateImpl.newInstance(this, getRuntimeService().createEventSubscriptionQuery().executionId(getExecutionId()).singleResult());
  }

}
