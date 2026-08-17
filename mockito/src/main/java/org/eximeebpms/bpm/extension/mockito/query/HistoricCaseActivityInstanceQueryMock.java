package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.HistoryService;
import org.eximeebpms.bpm.engine.history.HistoricCaseActivityInstance;
import org.eximeebpms.bpm.engine.history.HistoricCaseActivityInstanceQuery;

public class HistoricCaseActivityInstanceQueryMock extends AbstractQueryMock<HistoricCaseActivityInstanceQueryMock, HistoricCaseActivityInstanceQuery, HistoricCaseActivityInstance, HistoryService> {

  public HistoricCaseActivityInstanceQueryMock() {
    super(HistoricCaseActivityInstanceQuery.class, HistoryService.class);
   }

}
