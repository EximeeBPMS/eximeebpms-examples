package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.RuntimeService;
import org.eximeebpms.bpm.engine.runtime.EventSubscription;
import org.eximeebpms.bpm.engine.runtime.EventSubscriptionQuery;

public class EventSubscriptionQueryMock extends AbstractQueryMock<EventSubscriptionQueryMock, EventSubscriptionQuery, EventSubscription, RuntimeService> {

  public EventSubscriptionQueryMock() {
    super(EventSubscriptionQuery.class, RuntimeService.class);
   }

}
