package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.HistoryService;
import org.eximeebpms.bpm.engine.history.HistoricIncident;
import org.eximeebpms.bpm.engine.history.HistoricIncidentQuery;

public class HistoricIncidentQueryMock extends AbstractQueryMock<HistoricIncidentQueryMock, HistoricIncidentQuery, HistoricIncident, HistoryService> {

  public HistoricIncidentQueryMock() {
    super(HistoricIncidentQuery.class, HistoryService.class);
   }

}
