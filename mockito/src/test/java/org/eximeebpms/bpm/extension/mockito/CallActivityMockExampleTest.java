package org.eximeebpms.bpm.extension.mockito;

import org.eximeebpms.bpm.engine.history.HistoricProcessInstance;
import org.eximeebpms.bpm.engine.impl.persistence.entity.TimerEntity;
import org.eximeebpms.bpm.engine.runtime.EventSubscription;
import org.eximeebpms.bpm.engine.runtime.Job;
import org.eximeebpms.bpm.engine.runtime.JobQuery;
import org.eximeebpms.bpm.engine.runtime.ProcessInstance;
import org.eximeebpms.bpm.engine.test.ProcessEngineRule;
import org.eximeebpms.bpm.extension.mockito.function.DeployProcess;
import org.eximeebpms.bpm.model.bpmn.Bpmn;
import org.eximeebpms.bpm.model.bpmn.BpmnModelInstance;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.eximeebpms.bpm.engine.variable.Variables.createVariables;
import static org.eximeebpms.bpm.extension.mockito.MostUsefulProcessEngineConfiguration.mostUsefulProcessEngineConfiguration;
import static org.eximeebpms.bpm.extension.mockito.ProcessExpressions.registerCallActivityMock;

public class CallActivityMockExampleTest {

  private static final String PROCESS_ID = "myProcess";
  private static final String SUB_PROCESS_ID = "mySubProcess";
  private static final String SUB_PROCESS2_ID = "mySubProcess2";
  private static final String MESSAGE_DOIT = "DOIT";
  private static final String SIGNAL_ALLDOIT = "ALLDOIT";
  private static final String TASK_USERTASK = "user_task";

  @Rule
  public final ProcessEngineRule engine = new ProcessEngineRule(mostUsefulProcessEngineConfiguration().buildProcessEngine());

  @Before
  public void setUp() {
    prepareProcessWithOneSubprocess();
  }

  @Test
  public void register_subprocess_mock_addVar() {
    engine.manageDeployment(registerCallActivityMock(SUB_PROCESS_ID)
      .onExecutionAddVariable("foo", "bar")
      .deploy(engine));

    final ProcessInstance processInstance = startProcess(PROCESS_ID);
    isWaitingAt(processInstance, TASK_USERTASK);

    //TODO doesn't work with current eximeebpms-bpm-assert version (1.*) and our assertj version (3.*)
    //assertThat(processInstance).hasVariables("foo", "bar");
    final Map<String, Object> variables = engine.getRuntimeService().getVariables(processInstance.getId());
    assertThat(variables).hasSize(1);
    assertThat(variables).containsEntry("foo", "bar");
  }

  @Test
  public void register_subprocess_mock_withOwnConsumer() {
    engine.manageDeployment(registerCallActivityMock(SUB_PROCESS_ID)
      .onExecutionDo(execution -> {
        execution.setVariable("foo", "barbar");
      })
      .deploy(engine));

    final ProcessInstance processInstance = startProcess(PROCESS_ID);
    isWaitingAt(processInstance, TASK_USERTASK);

    //TODO doesn't work with current eximeebpms-bpm-assert version (1.*) and our assertj version (3.*)
    //assertThat(processInstance).hasVariables("foo", "bar");
    final Map<String, Object> variables = engine.getRuntimeService().getVariables(processInstance.getId());
    assertThat(variables).hasSize(1);
    assertThat(variables).containsEntry("foo", "barbar");
  }

  @Test
  public void register_subprocess_mock_withReceiveMessage() {
    engine.manageDeployment(registerCallActivityMock(SUB_PROCESS_ID)
      .onExecutionWaitForMessage(MESSAGE_DOIT)
      .deploy(engine));

    final ProcessInstance processInstance = startProcess(PROCESS_ID);
    assertThatProcessIsWaitingForMessage(MESSAGE_DOIT);

    engine.getRuntimeService().correlateMessage(MESSAGE_DOIT);
    isWaitingAt(processInstance, TASK_USERTASK);
  }

  @Test
  public void register_subprocess_mock_withReceiveSignal() {
    engine.manageDeployment(registerCallActivityMock(SUB_PROCESS_ID)
      .onExecutionWaitForSignal(SIGNAL_ALLDOIT)
      .deploy(engine));

    final ProcessInstance processInstance = startProcess(PROCESS_ID);
    assertThatProcessIsWaitingForSignal(SIGNAL_ALLDOIT);

    engine.getRuntimeService().createSignalEvent(SIGNAL_ALLDOIT).send();
    isWaitingAt(processInstance, TASK_USERTASK);
  }

  @Test
  public void register_subprocess_mock_withSendMessage() {
    engine.manageDeployment(
      registerCallActivityMock(SUB_PROCESS_ID)
        .onExecutionSendMessage(MESSAGE_DOIT)
        .deploy(engine)
    );

    final String waitForMessageId = "waitForMessage";
    final BpmnModelInstance waitForMessage = Bpmn.createExecutableProcess(waitForMessageId)
      .startEvent("start")
      .intermediateCatchEvent("waitForMessageCatchEvent")
      .message(MESSAGE_DOIT)
      .endEvent("end")
      .done();

    engine.manageDeployment(new DeployProcess(engine).apply(waitForMessageId, waitForMessage));

    //Start monitoring process for testing
    final ProcessInstance waitingProcessInstance = startProcess(waitForMessageId);
    assertThatProcessIsWaitingForMessage(MESSAGE_DOIT);

    //Start our process with mocked subprocess
    final ProcessInstance processInstance = startProcess(PROCESS_ID);
    isWaitingAt(processInstance, TASK_USERTASK);
    //Our monitoring process should be finished
    isEnded(waitingProcessInstance);
  }

  @Test
  public void register_subprocess_mock_withTimerDate() {
    final Date date = Date.from(Instant.now().plusSeconds(60));

    registerCallActivityMock(SUB_PROCESS_ID)
      .onExecutionWaitForTimerWithDate(date)
      .deploy(engine);

    startProcess(PROCESS_ID);

    assertThatTimerIsWaitingUntil(date);
  }

  @Test
  public void register_subprocess_mock_withTimerDuration() {
    engine.manageDeployment(registerCallActivityMock(SUB_PROCESS_ID)
      .onExecutionWaitForTimerWithDuration("PT60S")
      .deploy(engine));

    startProcess(PROCESS_ID);

    assertThatTimerIsWaitingUntil(Date.from(Instant.now().plusSeconds(60)));
  }

  @Test(expected = RuntimeException.class)
  public void register_subprocess_mock_withException() {
    engine.manageDeployment(registerCallActivityMock(SUB_PROCESS_ID)
      .onExecutionRunIntoError(new Exception("No"))
      .deploy(engine));

    startProcess(PROCESS_ID);
  }

  @Test
  public void register_subprocesses_mocks_withVariables() {
    final BpmnModelInstance processWithSubProcess = Bpmn.createExecutableProcess(PROCESS_ID)
      .startEvent("start")
      .callActivity("call_subprocess")
      .camundaOut("foo", "foo")
      .calledElement(SUB_PROCESS_ID)
      .callActivity("call_subprocess2")
      .calledElement(SUB_PROCESS2_ID)
      .camundaOut("bar", "bar")
      .userTask(TASK_USERTASK)
      .endEvent("end")
      .done();

    engine.manageDeployment(new DeployProcess(engine).apply(PROCESS_ID, processWithSubProcess));

    registerCallActivityMock(SUB_PROCESS_ID)
      .onExecutionSetVariables(createVariables().putValue("foo", "bar"))
      .deploy(engine);
    registerCallActivityMock(SUB_PROCESS2_ID)
      .onExecutionSetVariables(createVariables().putValue("bar", "foo"))
      .deploy(engine);

    final ProcessInstance processInstance = startProcess(PROCESS_ID);
    isWaitingAt(processInstance, TASK_USERTASK);

    //TODO doesn't work with current eximeebpms-bpm-assert version (1.*) and our assertj version (3.*)
    //assertThat(processInstance).hasVariables("foo", "bar");
    final Map<String, Object> variables = engine.getRuntimeService().getVariables(processInstance.getId());
    assertThat(variables).hasSize(2);
    assertThat(variables).containsEntry("foo", "bar");
    assertThat(variables).containsEntry("bar", "foo");
  }

  @Test
  public void register_subprocesses_mocks_withWaitMessage_and_timer_and_setVariable() {
    prepareProcessWithOneSubprocess();

    final Date waitUntil = Date.from(Instant.now().plusSeconds(60));
    registerCallActivityMock(SUB_PROCESS_ID)
      .onExecutionWaitForMessage(MESSAGE_DOIT)
      .onExecutionWaitForTimerWithDate(waitUntil)
      .onExecutionSetVariables(createVariables().putValue("foo", "bar"))
      .deploy(engine);

    final ProcessInstance processInstance = startProcess(PROCESS_ID);

    //Message should wait for message
    assertThatProcessIsWaitingForMessage(MESSAGE_DOIT);
    engine.getRuntimeService().correlateMessage(MESSAGE_DOIT);

    //Message should wait for date
    Job job = assertThatTimerIsWaitingUntil(waitUntil);
    execute(job);

    //Process should wait at user task
    isWaitingAt(processInstance, TASK_USERTASK);

    //TODO doesn't work with current eximeebpms-bpm-assert version (1.*) and our assertj version (3.*)
    //assertThat(processInstance).hasVariables("foo", "bar");
    final Map<String, Object> variables = engine.getRuntimeService().getVariables(processInstance.getId());
    assertThat(variables).hasSize(1);
    assertThat(variables).containsEntry("foo", "bar");
  }

  private void prepareProcessWithOneSubprocess() {
    final BpmnModelInstance processWithSubProcess = Bpmn.createExecutableProcess(PROCESS_ID)
      .startEvent("start")
      .callActivity("call_subprocess")
      .camundaOut("foo", "foo")
      .calledElement(SUB_PROCESS_ID)
      .userTask(TASK_USERTASK)
      .endEvent("end")
      .done();

    engine.manageDeployment(new DeployProcess(engine).apply(PROCESS_ID, processWithSubProcess));
  }

  private void assertThatProcessIsWaitingForMessage(String message) {
    final EventSubscription eventSubscription = engine.getRuntimeService().createEventSubscriptionQuery().singleResult();
    assertThat(eventSubscription).isNotNull();
    assertThat(eventSubscription.getEventName()).isEqualTo(message);
  }

  private void assertThatProcessIsWaitingForSignal(String signalName) {
    final EventSubscription eventSubscription = engine.getRuntimeService().createEventSubscriptionQuery().singleResult();
    assertThat(eventSubscription).isNotNull();
    assertThat(eventSubscription.getEventName()).isEqualTo(signalName);
  }

  private Job assertThatTimerIsWaitingUntil(Date date) {
    final List<Job> list = jobQuery().list();
    assertThat(list).hasSize(1);
    final Job timer = list.get(0);
    assertThat(timer).isInstanceOf(TimerEntity.class);
    assertThat(timer.getDuedate()).isInSameSecondWindowAs(date); // Check the time distance (second boundary does not matter)
    return timer;
  }

  private ProcessInstance startProcess(final String key) {
    return engine.getRuntimeService().startProcessInstanceByKey(key);
  }


  private void isWaitingAt(ProcessInstance processInstance, String activityId) {
    assertThat(engine.getRuntimeService().createProcessInstanceQuery().processInstanceId(processInstance.getId()).activityIdIn(activityId).active().singleResult()).isNotNull();
  }

  private void isEnded(ProcessInstance processInstance) {
    Optional<HistoricProcessInstance> hi = Optional.ofNullable(engine.getHistoryService().createHistoricProcessInstanceQuery().processInstanceId(processInstance.getId()).singleResult())
      .filter(h -> h.getEndTime() != null);

    assertThat(hi).as("instance not ended").isNotEmpty();
  }

  private JobQuery jobQuery() {
    return engine.getManagementService().createJobQuery().active();
  }

  private void execute(Job job) {
    engine.getManagementService().executeJob(job.getId());
  }
}
