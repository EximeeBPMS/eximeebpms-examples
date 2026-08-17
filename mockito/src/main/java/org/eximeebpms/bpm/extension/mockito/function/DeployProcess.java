package org.eximeebpms.bpm.extension.mockito.function;

import org.eximeebpms.bpm.engine.ProcessEngineServices;
import org.eximeebpms.bpm.engine.RepositoryService;
import org.eximeebpms.bpm.engine.repository.Deployment;
import org.eximeebpms.bpm.model.bpmn.BpmnModelInstance;

import java.util.function.BiFunction;

public class DeployProcess implements BiFunction<String, BpmnModelInstance, Deployment> {

  private final RepositoryService repositoryService;

  public DeployProcess(RepositoryService repositoryService) {
    this.repositoryService = repositoryService;
  }

  public DeployProcess(ProcessEngineServices processEngineServices) {
    this(processEngineServices.getRepositoryService());
  }


  public Deployment apply(String processId, BpmnModelInstance instance) {
    return repositoryService.createDeployment()
      .addModelInstance(processId + ".bpmn", instance)
      .deploy();
  }
}
