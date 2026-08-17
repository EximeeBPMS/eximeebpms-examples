package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.RuntimeService;
import org.eximeebpms.bpm.engine.runtime.Execution;
import org.eximeebpms.bpm.engine.runtime.ExecutionQuery;

public class ExecutionQueryMock extends AbstractQueryMock<ExecutionQueryMock, ExecutionQuery, Execution, RuntimeService> {

  public ExecutionQueryMock() {
    super(ExecutionQuery.class, RuntimeService.class);
   }

}
