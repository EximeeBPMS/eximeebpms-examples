package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.RepositoryService;
import org.eximeebpms.bpm.engine.repository.CaseDefinition;
import org.eximeebpms.bpm.engine.repository.CaseDefinitionQuery;

public class CaseDefinitionQueryMock extends AbstractQueryMock<CaseDefinitionQueryMock, CaseDefinitionQuery, CaseDefinition, RepositoryService> {

  public CaseDefinitionQueryMock() {
    super(CaseDefinitionQuery.class, RepositoryService.class);
   }

}
