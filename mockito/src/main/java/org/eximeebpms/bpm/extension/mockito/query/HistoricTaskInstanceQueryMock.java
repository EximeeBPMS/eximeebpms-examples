package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.HistoryService;
import org.eximeebpms.bpm.engine.history.HistoricTaskInstance;
import org.eximeebpms.bpm.engine.history.HistoricTaskInstanceQuery;

public class HistoricTaskInstanceQueryMock extends AbstractQueryMock<HistoricTaskInstanceQueryMock, HistoricTaskInstanceQuery, HistoricTaskInstance, HistoryService> {

  public HistoricTaskInstanceQueryMock() {
    super(HistoricTaskInstanceQuery.class, HistoryService.class);
   }

}
