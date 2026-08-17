package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.RepositoryService;
import org.eximeebpms.bpm.engine.repository.Deployment;
import org.eximeebpms.bpm.engine.repository.DeploymentQuery;

public class DeploymentQueryMock extends AbstractQueryMock<DeploymentQueryMock, DeploymentQuery, Deployment, RepositoryService> {

  public DeploymentQueryMock() {
    super(DeploymentQuery.class, RepositoryService.class);
   }

}
