package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.RepositoryService;
import org.eximeebpms.bpm.engine.repository.DecisionDefinition;
import org.eximeebpms.bpm.engine.repository.DecisionDefinitionQuery;

public class DecisionDefinitionQueryMock extends AbstractQueryMock<DecisionDefinitionQueryMock, DecisionDefinitionQuery, DecisionDefinition, RepositoryService> {

  public DecisionDefinitionQueryMock() {
    super(DecisionDefinitionQuery.class, RepositoryService.class);
   }

}
