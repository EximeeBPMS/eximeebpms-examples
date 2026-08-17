<a href="https://github.com/eximeebpms/eximeebpms-examples" target="_blank"><img src="https://img.shields.io/badge/Community%20Extension-An%20open%20source%20community%20maintained%20project-FF4700"></img></a>

> **Note:** not yet published to Maven Central - the dependency snippets below won't
> resolve remotely yet. Clone this repository and run `mvn install` in `assert-scenario/`
> first. Publishing is mechanically ready (see `.github/workflows/release-assert-scenario.yml`)
> but no release has been run yet. The first release will be tagged as an alpha
> (e.g. `1.0.0-alpha.1`), matching the maturity level the upstream `camunda-platform-scenario`
> project itself never got past (its own last releases were `2.0.0-alpha.1`/`.2` - Camunda 7
> is no longer developed, so this fork starts its own version line where upstream left off).

# EximeeBPMS <strong>Platform Scenario</strong>

This community extension to EximeeBPMS enables you to write **robust test suites** for process models. The larger
your process models, the more often you change them, the more value you will get out of using it. Look at a piece of
test code:

```groovy
@Test
public void testHappyPath() {
  // "given" part of the test
  when(process.waitsAtUserTask("CompleteWork")).thenReturn( 
    (task) -> task.complete()
  );
  // "when" part of the test
  run(process).startByKey("ReadmeProcess").execute();      
  // "then" part of the test  
  verify(process).hasFinished("WorkFinished");             
}
```

The code follows the [GivenWhenThen](http://martinfowler.com/bliki/GivenWhenThen.html) style of representing tests.

1. The **given** part describes pre-conditions to the test: you define here a process **scenario** by coding actions to
   happen when the process arrives at **waitstates** such as user tasks, receive tasks, event based gateways etc.
2. The **when** part executes the specified scenario: it is now **run** through to its end
3. The **then** part describes the expected end state: you e.g. **verify** that the process instance reached an end
   event

Now look at the process under test. Aside of the "happy path", we also want to check the requirement that the colleague
in charge of the work needs to be reminded daily to actually do it! :smile: In order to test **time-related** behaviour
of processes, the library allows to "defer" actions for specified time periods. The following test code snippet verifies
the example case, that the colleague should be reminded twice, in case he needs 2 1/2 days to complete the work.

<img src="https://github.com/camunda-community-hub/camunda-platform-scenario/raw/master/doc/img/readme-process.png" width="400" align="left"/>

```groovy
@Test
public void testSlowPath() {
  when(process.waitsAtUserTask("CompleteWork")).thenReturn(
    (task) -> task.defer("P2DT12H", () -> task.complete())
  );
  when(process.waitsAtUserTask("RemindColleague")).thenReturn(
    (task) -> task.complete()
  );
  run(process).startByKey("ReadmeProcess").execute();
  verify(process).hasFinished("WorkFinished");
  verify(process, times(2)).hasFinished("ColleagueReminded");
}
```

Note that such **time-aware scenarios** work across **interacting process instances** and whole **trees of call
activities**.

## Our motivations

**EximeeBPMS Platform Scenario** enables much **faster process development**, removing the need to adapt unit test
suites for large executable models over and over again. When using it we experience that just those tests need to
break that we want to break: when we change the "business relevant" aspect under test or **what** the process
achieves. However, our test suites do not break at all when we just refactor a model's inner logic or **how** we
achieve the desired business semantics.

Furthermore, _EximeeBPMS Platform Scenario_ enables **realistic unit testing** with respect to **time-related** process
behaviour: by deferring actions and "fast-forwarding" test scenarios into their "process future", we can check how
several processes and call activities behave together. We however always remain in the driver's seat: _EximeeBPMS
Platform Scenario_ works in a single-treaded, easily mockable and controllable unit test environment.

## Show me more code!

The library provides you with a callback interface `ProcessScenario`. Implementing this interface allows you to define
up front what needs to happen at the "waitstates" of your process under test. Typical "waitstates" are user tasks,
receive tasks, intermediate catching events and some more, in particular also "external" service tasks. But instead of
simply implementing this interface you will typically mock its behaviour by making use of your preferred mocking
framework. Let's look at an example using the Mockito framework:

```groovy
@Mock private ProcessScenario insuranceApplication;
...
@Before
public void defineHappyScenario() {
  when(insuranceApplication.waitsAtUserTask("UserTaskDecideAboutApplication")).thenReturn((task) ->
    taskService.complete(task.getId(), Variables.putValue("approved", true))
  );
}
```

Note that there is no dependency to any mocking framework. The presented code snippet just happens to use Mockito to
define that in case the ProcessScenario `insuranceApplication` arrives at and waits at the user
task `UserTaskDecideAboutApplication`, we simply want to complete that task by passing a process
variable `approved = true`. Once you have defined behaviour for all your process' waitstates you can execute such a
scenario. There are several possibilities, the simplest of which would be to write:

```groovy
@Test
public void testHappyPath() {
  Scenario.run(insuranceApplication).startByKey("InsuranceApplication").execute();
  ...
}
```

This means you start a new process instance by key and run it through to to its end. At the waitstates, your predefined
actions apply, right? But obviously you also want to verify now "after the fact", that your process actually did what
you really care about from a business perspective. It's worthwile to think about that notion a bit. We specified above
that we approve the insurance application, so one thing we definitely care about is that our process reaches the "happy"
end event. The full test case description could therefore look like:

```groovy
@Test
public void testHappyPath() {
  // WHEN we execute the scenario with the default, "happy" waitstate behaviour ...
  Scenario.run(insuranceApplication).startByKey("InsuranceApplication").execute();
  // THEN we expect the process instance to finish with a "happy" end, the application being accepted ...
  verify(insuranceApplication).hasFinished("EndEventApplicationAccepted");
}
```

Note that in the last line, we simply consult the mocking framework to tell us about the interactions of our scenario
execution with the `ProcessScenario` interface provided by us.

## An extensive example: applying for insurance with "Camundanzia"! :smile:

The following process scenario has been executed by means of _EximeeBPMS Platform Scenario_ and has been visualised
with the [Camunda Process Test Coverage](https://github.com/camunda-community-hub/camunda-bpm-process-test-coverage)
library (confirmed incompatible with the renamed engine, out of scope for this fork - see
docs-camunda-repository-references.md).

![](https://github.com/camunda-community-hub/camunda-platform-scenario/raw/master/doc/img/insurance-application.png)

Note that we see here a call activity `Document Request` invoked by an event sub process. Why does our scenario run
show this path? Who takes care of the call activity's details? And why does the boundary timer `2 days` actually
trigger? Please have a look at the
[few lines of test code](https://github.com/camunda-community-hub/camunda-platform-scenario/blob/master/example/src/test/java/org/camunda/bpm/scenario/examples/insuranceapplication/InsuranceApplicationProcessTest.java#L247)
necessary to create this particular scenario!

## Highlights

1. Define **default waitstate actions** once and **override** them with a different behaviour in your test methods
1. Eliminate almost all querying for runtime objects as e.g. tasks, you get the **instances injected into your actions**
1. **Introduce or remove transaction borders** ("savepoints": asyncBefore/asyncAfter) without affecting your tests
1. Execute **several process instances** alongside each other including whole **trees of call activities**
1. Enable realistic **time-related** unit testing by **deferring** waitstate actions for a period of time
1. Create a **realistic history** by defining time needed for all actions and "fast-forwarding" into the future
1. Use scenarios with [**EximeeBPMS Assert**](https://docs.eximeebpms.org) to verify current runtime state inside your
   waitstate actions

## Just start to use it!

EximeeBPMS Platform Scenario is built and tested against EximeeBPMS version 1.3.0.

## Get started in _3 simple steps_!

**1.** Add a maven **test dependency** to your project:

**Legacy artifact coordinates** (matches the original `camunda-bpm-assert-scenario` naming):

```xml  
<dependency>
    <groupId>org.eximeebpms.bpm.extension</groupId>
    <artifactId>eximeebpms-bpm-assert-scenario</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <scope>test</scope>
</dependency>
```

**or the current `platform-scenario` artifact coordinates**:

```xml  
<dependency>
    <groupId>org.eximeebpms.bpm.extension.scenario</groupId>
    <artifactId>eximeebpms-platform-scenario-runner</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <scope>test</scope>
</dependency>
```

**2.** Add a mocked `ProcessScenario` to your test class

Create your test case just as described in the
[EximeeBPMS Testing Guide](https://docs.eximeebpms.org/manual/latest/user-guide/testing/). Then add EximeeBPMS
Platform Scenario Runner by mocking its main interface - the example shown here makes use of Mockito:

```java
ProcessScenario insuranceApplication = mock(ProcessScenario.class);
...
@Before
public void defineHappyScenario() {
  when(insuranceApplication.waitsAtUserTask("UserTaskDecideAboutApplication")).thenReturn((task) ->
    task.complete()
  );
}
```

**3.** Start executing and verifying your scenarios in your **test methods**

```java
@Test
public void testHappyPath() {
  Scenario.run(insuranceApplication).startByKey("InsuranceApplication").execute();
  verify(insuranceApplication, times(1)).hasFinished("EndEventApplicationAccepted");
}
```

Green bar? Congrats! You are successfully using EximeeBPMS Platform Scenario.

## Add extensive logging to your tests

Turn on the logger 'org.eximeebpms.bpm.scenario' and you will see detailed information about the execution of scenarios.
The details of configuration depend on your logging framework - when using logback, you would e.g. write
in `logback.xml`

```xml
<logger name="org.eximeebpms.bpm.scenario" level="debug" /> <!-- or info -->
```

For optimally readably output, it can make a lot of sense to turn off all other logging, because scenario logging
displays the
"fast forwarding" of process time like e.g. shown in the following example test ouput:

```bash
...
| Started   receiveTask        'Wait for documents' (ReceiveTaskWaitForDocuments @ DocumentRequest # dad1fecf-dda0-11e6-906e-7ebec62e68c4)
* Acting on receiveTask        'Wait for documents' (ReceiveTaskWaitForDocuments @ DocumentRequest # dad1fecf-dda0-11e6-906e-7ebec62e68c4)
| Deferring action on          'Wait for documents' until 2017-01-25 18:10:21 (ReceiveTaskWaitForDocuments @ DocumentRequest # dad1fecf-dda0-11e6-906e-7ebec62e68c4 ...
| Fast-forwarding scenario to 2017-01-19 18:09:21
|-- Executing timer-transition   (BoundaryEventDaily @ DocumentRequest # dad1fecf-dda0-11e6-906e-7ebec62e68c4)
  | Started   boundaryTimer      'daily' (BoundaryEventDaily @ DocumentRequest # dad1fecf-dda0-11e6-906e-7ebec62e68c4)
  | Completed boundaryTimer      'daily' (BoundaryEventDaily @ DocumentRequest # dad1fecf-dda0-11e6-906e-7ebec62e68c4)
  | Started   sendTask           'Send reminder' (SendTaskSendReminder @ DocumentRequest # dad1fecf-dda0-11e6-906e-7ebec62e68c4)
  * Acting on sendTask           'Send reminder' (SendTaskSendReminder @ DocumentRequest # dad1fecf-dda0-11e6-906e-7ebec62e68c4)
  | Completed sendTask           'Send reminder' (SendTaskSendReminder @ DocumentRequest # dad1fecf-dda0-11e6-906e-7ebec62e68c4)
  | Started   noneEndEvent       'Reminder sent' (EndEvent_1 @ DocumentRequest # dad1fecf-dda0-11e6-906e-7ebec62e68c4)
  | Completed noneEndEvent       'Reminder sent' (EndEvent_1 @ DocumentRequest # dad1fecf-dda0-11e6-906e-7ebec62e68c4)
  | Fast-forwarding scenario to 2017-01-20 18:09:21
  |-- Executing timer-transition   (BoundaryEvent_2 @ InsuranceApplication # dacca880-dda0-11e6-906e-7ebec62e68c4)
    | Started   boundaryTimer      '2 days' (BoundaryEvent_2 @ InsuranceApplication # dacca880-dda0-11e6-906e-7ebec62e68c4)
    | Completed boundaryTimer      '2 days' (BoundaryEvent_2 @ InsuranceApplication # dacca880-dda0-11e6-906e-7ebec62e68c4)
    | Started   userTask           'Speed up manual check' (UserTaskSpeedUpManualCheck @ InsuranceApplication # dacca880-dda0-11e6-906e-7ebec62e68c4)
...
```

Whenever the scenario fast-forwards in time, the log output moves a bit to the right.

## Further Resources

* [Maintenance (upstream)](https://plexiti.com/)
* [Issue Tracker (upstream)](https://github.com/camunda-community-hub/camunda-platform-scenario/issues)
* [Blog (upstream)](https://medium.com/plexiti)

## Maintenance &amp; License

<a href="http://plexiti.com"><img src="https://plexiti.com/images/plexiti-transparent.png" align="right"></img></a>
Martin Schimak<br/>[Company](https://plexiti.com/) &#8226; [GitHub](https://github.com/martinschimak)
&#8226; [eMail](mailto:martin.schimak@plexiti.com)<br/>Apache License, Version 2.0

## Contributions and Sponsorship

<a href="http://www.wdw-consulting.com"><img src="/doc/img/wdw-elab.png" align="right"></img></a>This library is written
by Martin Schimak (plexiti) and evolved out of real life project needs at WDW eLab and in close collaboration with the
software development team at WDW eLab's Vienna office. It could not have been brought to light without the open
mindedness and open source mindedness I experienced with WDW eLab. **You rock! :smile:**

**You** want to **contribute**? You are very welcome! Please contact me directly
via [eMail](mailto:martin.schimak@plexiti.com).
