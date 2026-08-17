package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.HistoryService;
import org.eximeebpms.bpm.engine.history.HistoricDetail;
import org.eximeebpms.bpm.engine.history.HistoricDetailQuery;

public class HistoricDetailQueryMock extends AbstractQueryMock<HistoricDetailQueryMock, HistoricDetailQuery, HistoricDetail, HistoryService> {

  public HistoricDetailQueryMock() {
    super(HistoricDetailQuery.class, HistoryService.class);
   }

}
