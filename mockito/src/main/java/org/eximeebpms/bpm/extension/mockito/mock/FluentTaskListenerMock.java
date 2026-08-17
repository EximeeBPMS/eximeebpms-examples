package org.eximeebpms.bpm.extension.mockito.mock;

import static org.mockito.Mockito.mock;

import org.eximeebpms.bpm.engine.delegate.BpmnError;
import org.eximeebpms.bpm.engine.delegate.DelegateTask;
import org.eximeebpms.bpm.engine.delegate.TaskListener;
import org.eximeebpms.bpm.engine.variable.VariableMap;
import org.eximeebpms.bpm.extension.mockito.answer.TaskListenerAnswer;
import org.mockito.Mockito;

public class FluentTaskListenerMock extends FluentMock<TaskListener, DelegateTask> implements TaskListener {

  public FluentTaskListenerMock() {
    super(mock(TaskListener.class), DelegateTask.class);
  }

  @Override
  public final void notify(final DelegateTask delegateTask) {
    mock.notify(delegateTask);
  }

  @Override
  public void onExecutionSetVariables(final VariableMap variables) {
    doAnswer(new TaskListener() {

      @Override
      public void notify(final DelegateTask delegateTask) {
        setVariables(delegateTask, variables);
      }
    });
  }

  @Override
  public void onExecutionThrowBpmnError(final BpmnError bpmnError) {
    doAnswer(new TaskListener() {

      @Override
      public void notify(final DelegateTask delegateTask) {
        throw bpmnError;
      }
    });
  }

  @Override
  public void onExecutionThrowException(final Exception exception) {
    doAnswer(new TaskListener() {
      @Override
      public void notify(DelegateTask delegateTask) {
        throw new RuntimeException(exception);
      }
    });
  }

  private void doAnswer(final TaskListener taskListener) {
    try {
      Mockito.doAnswer(new TaskListenerAnswer(taskListener)).when(mock).notify(any());
    } catch (final Exception e) {
      throw new RuntimeException(e);
    }
  }
}
