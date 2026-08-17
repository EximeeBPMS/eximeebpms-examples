package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.HistoryService;
import org.eximeebpms.bpm.engine.history.HistoricProcessInstance;
import org.eximeebpms.bpm.engine.history.HistoricProcessInstanceQuery;

public class HistoricProcessInstanceQueryMock extends AbstractQueryMock<HistoricProcessInstanceQueryMock, HistoricProcessInstanceQuery, HistoricProcessInstance, HistoryService> {

  public HistoricProcessInstanceQueryMock() {
    super(HistoricProcessInstanceQuery.class, HistoryService.class);
   }

}
