package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.HistoryService;
import org.eximeebpms.bpm.engine.batch.history.HistoricBatch;
import org.eximeebpms.bpm.engine.batch.history.HistoricBatchQuery;

public class HistoricBatchQueryMock extends AbstractQueryMock<HistoricBatchQueryMock, HistoricBatchQuery, HistoricBatch, HistoryService> {

  public HistoricBatchQueryMock() {
    super(HistoricBatchQuery.class, HistoryService.class);
   }

}
