package org.eximeebpms.bpm.scenario.run;

import org.eximeebpms.bpm.engine.runtime.ProcessInstance;

/**
 * @author Martin Schimak
 */
public interface ProcessStarter {

  /**
   * Method to be implemented with custom code to start a
   * process instance.
   *
   * @return a new process instance started by custom code
   */
  ProcessInstance start();

}
