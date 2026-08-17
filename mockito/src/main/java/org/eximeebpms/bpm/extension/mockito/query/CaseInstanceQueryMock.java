package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.CaseService;
import org.eximeebpms.bpm.engine.runtime.CaseInstance;
import org.eximeebpms.bpm.engine.runtime.CaseInstanceQuery;

public class CaseInstanceQueryMock extends AbstractQueryMock<CaseInstanceQueryMock, CaseInstanceQuery, CaseInstance, CaseService> {

  public CaseInstanceQueryMock() {
    super(CaseInstanceQuery.class, CaseService.class);
   }

}
