package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.RuntimeService;
import org.eximeebpms.bpm.engine.runtime.ProcessInstance;
import org.eximeebpms.bpm.engine.runtime.ProcessInstanceQuery;

public class ProcessInstanceQueryMock extends AbstractQueryMock<ProcessInstanceQueryMock, ProcessInstanceQuery, ProcessInstance, RuntimeService> {

  public ProcessInstanceQueryMock() {
    super(ProcessInstanceQuery.class, RuntimeService.class);
   }

}
