package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.HistoryService;
import org.eximeebpms.bpm.engine.history.UserOperationLogEntry;
import org.eximeebpms.bpm.engine.history.UserOperationLogQuery;

public class UserOperationLogQueryMock extends AbstractQueryMock<UserOperationLogQueryMock, UserOperationLogQuery, UserOperationLogEntry, HistoryService> {

  public UserOperationLogQueryMock() {
    super(UserOperationLogQuery.class, HistoryService.class);
   }

}
