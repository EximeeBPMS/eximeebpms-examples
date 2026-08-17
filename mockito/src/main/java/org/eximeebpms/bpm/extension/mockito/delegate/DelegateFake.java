package org.eximeebpms.bpm.extension.mockito.delegate;

import org.eximeebpms.bpm.engine.ProcessEngine;
import org.eximeebpms.bpm.engine.ProcessEngineServices;
import org.eximeebpms.bpm.engine.delegate.ProcessEngineServicesAware;
import org.eximeebpms.bpm.model.bpmn.instance.FlowElement;
import org.mockito.Mockito;

import static org.mockito.Answers.RETURNS_DEEP_STUBS;

abstract class DelegateFake<T extends DelegateFake> extends VariableScopeFake<T> implements ProcessEngineServicesAware {

  protected final ProcessEngineServicesAwareFake processEngineServicesAwareFake = new ProcessEngineServicesAwareFake();

  @Override
  public ProcessEngineServices getProcessEngineServices() {
    return processEngineServicesAwareFake.getProcessEngineServices();
  }

  public T withProcessEngineServices(ProcessEngineServices processEngineServices) {
    processEngineServicesAwareFake.withProcessEngineServices(processEngineServices);
    return (T) this;
  }


  @Override
  public ProcessEngine getProcessEngine() {
    return processEngineServicesAwareFake.getProcessEngine();
  }

  public T withProcessEngine(ProcessEngine processEngine) {
    processEngineServicesAwareFake.withProcessEngine(processEngine);
    return (T) this;
  }

}
