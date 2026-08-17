package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.HistoryService;
import org.eximeebpms.bpm.engine.history.HistoricActivityInstance;
import org.eximeebpms.bpm.engine.history.HistoricActivityInstanceQuery;

public class HistoricActivityInstanceQueryMock extends AbstractQueryMock<HistoricActivityInstanceQueryMock, HistoricActivityInstanceQuery, HistoricActivityInstance, HistoryService> {

  public HistoricActivityInstanceQueryMock() {
    super(HistoricActivityInstanceQuery.class, HistoryService.class);
   }

}
