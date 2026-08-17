package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.HistoryService;
import org.eximeebpms.bpm.engine.history.HistoricJobLog;
import org.eximeebpms.bpm.engine.history.HistoricJobLogQuery;

public class HistoricJobLogQueryMock extends AbstractQueryMock<HistoricJobLogQueryMock, HistoricJobLogQuery, HistoricJobLog, HistoryService> {

  public HistoricJobLogQueryMock() {
    super(HistoricJobLogQuery.class, HistoryService.class);
   }

}
