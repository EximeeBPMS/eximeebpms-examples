package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.HistoryService;
import org.eximeebpms.bpm.engine.history.HistoricActivityStatistics;
import org.eximeebpms.bpm.engine.history.HistoricActivityStatisticsQuery;

public class HistoricActivityStatisticsQueryMock extends AbstractQueryMock<HistoricActivityStatisticsQueryMock, HistoricActivityStatisticsQuery, HistoricActivityStatistics, HistoryService> {

  public HistoricActivityStatisticsQueryMock() {
    super(HistoricActivityStatisticsQuery.class, HistoryService.class);
   }

}
