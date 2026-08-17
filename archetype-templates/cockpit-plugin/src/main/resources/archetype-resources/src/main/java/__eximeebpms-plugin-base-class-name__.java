package ${package};

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ${package}.resources.${eximeebpms-plugin-base-class-name}RootResource;
import org.eximeebpms.bpm.cockpit.plugin.spi.impl.AbstractCockpitPlugin;

public class ${eximeebpms-plugin-base-class-name} extends AbstractCockpitPlugin {

  public static final String ID = "${eximeebpms-plugin-id}";

  public String getId() {
    return ID;
  }

  @Override
  public Set<Class<?>> getResourceClasses() {
    Set<Class<?>> classes = new HashSet<Class<?>>();

    classes.add(${eximeebpms-plugin-base-class-name}RootResource.class);

    return classes;
  }

  @Override
  public List<String> getMappingFiles() {
    return Arrays.asList("${package}".replace(".", "/") + "/${eximeebpms-plugin-id}-query.xml");
  }
}
