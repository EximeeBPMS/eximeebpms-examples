package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.CaseService;
import org.eximeebpms.bpm.engine.runtime.CaseExecution;
import org.eximeebpms.bpm.engine.runtime.CaseExecutionQuery;

public class CaseExecutionQueryMock extends AbstractQueryMock<CaseExecutionQueryMock, CaseExecutionQuery, CaseExecution, CaseService> {

  public CaseExecutionQueryMock() {
    super(CaseExecutionQuery.class, CaseService.class);
   }

}
