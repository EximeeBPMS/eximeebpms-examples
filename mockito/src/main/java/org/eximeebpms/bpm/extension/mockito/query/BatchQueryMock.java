package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.ManagementService;
import org.eximeebpms.bpm.engine.batch.Batch;
import org.eximeebpms.bpm.engine.batch.BatchQuery;

public class BatchQueryMock extends AbstractQueryMock<BatchQueryMock, BatchQuery, Batch, ManagementService> {

  public BatchQueryMock() {
    super(BatchQuery.class, ManagementService.class);
   }

}
