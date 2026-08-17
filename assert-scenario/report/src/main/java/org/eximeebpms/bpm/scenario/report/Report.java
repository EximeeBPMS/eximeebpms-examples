package org.eximeebpms.bpm.scenario.report;

import org.eximeebpms.bpm.model.bpmn.BpmnModelInstance;
import org.eximeebpms.bpm.scenario.report.bpmn.ProcessCoverageReport;
import org.eximeebpms.bpm.scenario.report.bpmn.ProcessScenarioReport;
import org.eximeebpms.bpm.scenario.report.bpmn.ProcessScenarioTestReportGenerator;

/**
 * @author Martin Schimak
 */
public interface Report<R> {

  R generate(String id);

  static Report<BpmnModelInstance> processScenarioReport() {
    return new ProcessScenarioReport();
  }

  static Report<BpmnModelInstance> processCoverageReport() {
    return new ProcessCoverageReport();
  }

}
