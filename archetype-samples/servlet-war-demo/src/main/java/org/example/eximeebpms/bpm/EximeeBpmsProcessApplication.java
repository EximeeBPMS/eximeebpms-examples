package org.example.eximeebpms.bpm;

import org.eximeebpms.bpm.application.PostDeploy;
import org.eximeebpms.bpm.application.ProcessApplication;
import org.eximeebpms.bpm.application.impl.JakartaServletProcessApplication;
import org.eximeebpms.bpm.engine.ProcessEngine;

/**
 * Process Application exposing this application's resources to the process engine.
 */
@ProcessApplication
public class EximeeBpmsProcessApplication extends JakartaServletProcessApplication {

  /**
   * In a @PostDeploy Hook you can interact with the process engine and access
   * the processes the application has deployed.
   */
  // The original @PostDeploy setup (default users/groups/filters) used
  // third-party demo utilities (FilterGenerator, UserGenerator, LicenseHelper,
  // DemoDataGenerator) whose own method signatures take the pre-rename
  // org.camunda.bpm.engine.ProcessEngine, which no longer exists on the
  // classpath (only the renamed eximeebpms-engine does) - so calling them
  // here doesn't compile. Left as a no-op for now.
  @PostDeploy
  public void onDeploymentFinished(ProcessEngine processEngine) {
  }

}
