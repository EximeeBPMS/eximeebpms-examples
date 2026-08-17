package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.ManagementService;
import org.eximeebpms.bpm.engine.management.ProcessDefinitionStatistics;
import org.eximeebpms.bpm.engine.management.ProcessDefinitionStatisticsQuery;

public class ProcessDefinitionStatisticsQueryMock extends AbstractQueryMock<ProcessDefinitionStatisticsQueryMock, ProcessDefinitionStatisticsQuery, ProcessDefinitionStatistics, ManagementService> {

  public ProcessDefinitionStatisticsQueryMock() {
    super(ProcessDefinitionStatisticsQuery.class, ManagementService.class);
   }

}
