package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.ManagementService;
import org.eximeebpms.bpm.engine.runtime.Job;
import org.eximeebpms.bpm.engine.runtime.JobQuery;

public class JobQueryMock extends AbstractQueryMock<JobQueryMock, JobQuery, Job, ManagementService> {

  public JobQueryMock() {
    super(JobQuery.class, ManagementService.class);
   }

}
