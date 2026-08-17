package ${package}.resources;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import org.eximeebpms.bpm.cockpit.plugin.resource.AbstractCockpitPluginRootResource;

import ${package}.${eximeebpms-plugin-base-class-name};

@Path("plugin/" + ${eximeebpms-plugin-base-class-name}.ID)
public class ${eximeebpms-plugin-base-class-name}RootResource extends AbstractCockpitPluginRootResource {

  public ${eximeebpms-plugin-base-class-name}RootResource() {
    super(${eximeebpms-plugin-base-class-name}.ID);
  }

  @Path("{engineName}/process-instance")
  public ProcessInstanceResource getProcessInstanceResource(@PathParam("engineName") String engineName) {
    return subResource(new ProcessInstanceResource(engineName), engineName);
  }
}
