package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.HistoryService;
import org.eximeebpms.bpm.engine.history.HistoricIdentityLinkLog;
import org.eximeebpms.bpm.engine.history.HistoricIdentityLinkLogQuery;

public class HistoricIdentityLinkLogQueryMock extends AbstractQueryMock<HistoricIdentityLinkLogQueryMock, HistoricIdentityLinkLogQuery, HistoricIdentityLinkLog, HistoryService> {

  public HistoricIdentityLinkLogQueryMock() {
    super(HistoricIdentityLinkLogQuery.class, HistoryService.class);
   }

}
