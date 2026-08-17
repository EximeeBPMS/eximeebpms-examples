package org.eximeebpms.bpm.scenario.impl.job;

import org.eximeebpms.bpm.engine.runtime.Job;
import org.eximeebpms.bpm.scenario.impl.JobExecutable;
import org.eximeebpms.bpm.scenario.impl.ProcessRunnerImpl;

import java.util.Date;

/**
 * @author Martin Schimak
 */
public class ContinuationExecutable extends JobExecutable {

  public ContinuationExecutable(ProcessRunnerImpl runner, Job job) {
    super(runner, job);
  }

  @Override
  public Date isExecutableAt() {
    return new Date(0);
  }

}
