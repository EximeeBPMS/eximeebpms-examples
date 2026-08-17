package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.TaskService;
import org.eximeebpms.bpm.engine.task.Task;
import org.eximeebpms.bpm.engine.task.TaskQuery;

public class TaskQueryMock extends AbstractQueryMock<TaskQueryMock, TaskQuery, Task, TaskService> {

  public TaskQueryMock() {
    super(TaskQuery.class, TaskService.class);
   }

}
