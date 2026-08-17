package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.ManagementService;
import org.eximeebpms.bpm.engine.management.JobDefinition;
import org.eximeebpms.bpm.engine.management.JobDefinitionQuery;

public class JobDefinitionQueryMock extends AbstractQueryMock<JobDefinitionQueryMock, JobDefinitionQuery, JobDefinition, ManagementService> {

  public JobDefinitionQueryMock() {
    super(JobDefinitionQuery.class, ManagementService.class);
   }

}
