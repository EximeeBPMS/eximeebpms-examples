package org.eximeebpms.bpm.scenario.delegate;

import org.eximeebpms.bpm.engine.runtime.ProcessInstance;
import org.eximeebpms.bpm.scenario.defer.Deferrable;

/**
 * @author Martin Schimak
 */
public interface ProcessInstanceDelegate extends ProcessInstance, VariablesAwareDelegate, Deferrable {

}
