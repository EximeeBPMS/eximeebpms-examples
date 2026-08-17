package org.eximeebpms.bpm.scenario.impl.job;

import org.eximeebpms.bpm.engine.runtime.Job;
import org.eximeebpms.bpm.scenario.impl.JobExecutable;
import org.eximeebpms.bpm.scenario.impl.ProcessRunnerImpl;
import org.eximeebpms.bpm.scenario.impl.util.Time;

import java.util.Date;

/**
 * @author Martin Schimak
 */
public class TimerJobExecutable extends JobExecutable {

  public TimerJobExecutable(ProcessRunnerImpl runner, Job job) {
    super(runner, job);
  }

  @Override
  public Date isExecutableAt() {
    return Time.correct(delegate.getDuedate());
  }

  @Override
  public void executeJob() {
    Time.set(isExecutableAt());
    super.executeJob();
  }

}
