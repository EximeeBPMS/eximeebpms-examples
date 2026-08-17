package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.ExternalTaskService;
import org.eximeebpms.bpm.engine.externaltask.ExternalTask;
import org.eximeebpms.bpm.engine.externaltask.ExternalTaskQuery;

public class ExternalTaskQueryMock extends AbstractQueryMock<ExternalTaskQueryMock, ExternalTaskQuery, ExternalTask, ExternalTaskService> {

  public ExternalTaskQueryMock() {
    super(ExternalTaskQuery.class, ExternalTaskService.class);
   }

}
