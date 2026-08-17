package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.RepositoryService;
import org.eximeebpms.bpm.engine.repository.ProcessDefinition;
import org.eximeebpms.bpm.engine.repository.ProcessDefinitionQuery;

public class ProcessDefinitionQueryMock extends AbstractQueryMock<ProcessDefinitionQueryMock, ProcessDefinitionQuery, ProcessDefinition, RepositoryService> {

  public ProcessDefinitionQueryMock() {
    super(ProcessDefinitionQuery.class, RepositoryService.class);
   }

}
