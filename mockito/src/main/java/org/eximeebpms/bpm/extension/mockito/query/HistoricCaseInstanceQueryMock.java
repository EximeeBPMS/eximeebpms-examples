package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.HistoryService;
import org.eximeebpms.bpm.engine.history.HistoricCaseInstance;
import org.eximeebpms.bpm.engine.history.HistoricCaseInstanceQuery;

public class HistoricCaseInstanceQueryMock extends AbstractQueryMock<HistoricCaseInstanceQueryMock, HistoricCaseInstanceQuery, HistoricCaseInstance, HistoryService> {

  public HistoricCaseInstanceQueryMock() {
    super(HistoricCaseInstanceQuery.class, HistoryService.class);
   }

}
