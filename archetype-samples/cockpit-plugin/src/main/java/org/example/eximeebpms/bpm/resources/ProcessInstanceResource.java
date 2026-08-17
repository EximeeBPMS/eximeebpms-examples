package org.example.eximeebpms.bpm.resources;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.eximeebpms.bpm.cockpit.db.QueryParameters;
import org.eximeebpms.bpm.cockpit.plugin.resource.AbstractCockpitPluginResource;

import org.example.eximeebpms.bpm.db.ProcessInstanceCountDto;

public class ProcessInstanceResource extends AbstractCockpitPluginResource {

  public ProcessInstanceResource(String engineName) {
    super(engineName);
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<ProcessInstanceCountDto> getProcessInstanceCounts() {

    return getQueryService()
        .executeQuery(
          "org.example.eximeebpms.bpm.selectProcessInstanceCountsByProcessDefinition",
          new QueryParameters());
  }
}
