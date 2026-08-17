package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.RuntimeService;
import org.eximeebpms.bpm.engine.runtime.Incident;
import org.eximeebpms.bpm.engine.runtime.IncidentQuery;

public class IncidentQueryMock extends AbstractQueryMock<IncidentQueryMock, IncidentQuery, Incident, RuntimeService> {

  public IncidentQueryMock() {
    super(IncidentQuery.class, RuntimeService.class);
   }

}
