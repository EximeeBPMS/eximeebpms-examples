package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.ManagementService;
import org.eximeebpms.bpm.engine.batch.BatchStatistics;
import org.eximeebpms.bpm.engine.batch.BatchStatisticsQuery;

public class BatchStatisticsQueryMock extends AbstractQueryMock<BatchStatisticsQueryMock, BatchStatisticsQuery, BatchStatistics, ManagementService> {

  public BatchStatisticsQueryMock() {
    super(BatchStatisticsQuery.class, ManagementService.class);
   }

}
