package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.HistoryService;
import org.eximeebpms.bpm.engine.history.HistoricDecisionInstance;
import org.eximeebpms.bpm.engine.history.HistoricDecisionInstanceQuery;

public class HistoricDecisionInstanceQueryMock extends AbstractQueryMock<HistoricDecisionInstanceQueryMock, HistoricDecisionInstanceQuery, HistoricDecisionInstance, HistoryService> {

  public HistoricDecisionInstanceQueryMock() {
    super(HistoricDecisionInstanceQuery.class, HistoryService.class);
   }

}
