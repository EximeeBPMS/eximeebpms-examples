package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.RuntimeService;
import org.eximeebpms.bpm.engine.runtime.VariableInstance;
import org.eximeebpms.bpm.engine.runtime.VariableInstanceQuery;

public class VariableInstanceQueryMock extends AbstractQueryMock<VariableInstanceQueryMock, VariableInstanceQuery, VariableInstance, RuntimeService> {

  public VariableInstanceQueryMock() {
    super(VariableInstanceQuery.class, RuntimeService.class);
   }

}
