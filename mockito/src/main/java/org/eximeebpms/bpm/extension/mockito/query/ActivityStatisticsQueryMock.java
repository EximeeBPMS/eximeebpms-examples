package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.ManagementService;
import org.eximeebpms.bpm.engine.management.ActivityStatistics;
import org.eximeebpms.bpm.engine.management.ActivityStatisticsQuery;

public class ActivityStatisticsQueryMock extends AbstractQueryMock<ActivityStatisticsQueryMock, ActivityStatisticsQuery, ActivityStatistics, ManagementService> {

  public ActivityStatisticsQueryMock() {
    super(ActivityStatisticsQuery.class, ManagementService.class);
   }

}
