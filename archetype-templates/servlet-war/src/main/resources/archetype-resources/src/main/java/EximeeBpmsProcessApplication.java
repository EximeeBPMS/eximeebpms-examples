package ${package};

import org.eximeebpms.bpm.application.ProcessApplication;
import org.eximeebpms.bpm.application.impl.JakartaServletProcessApplication;

/**
 * Process Application exposing this application's resources to the process engine.
 */
@ProcessApplication
public class EximeeBpmsProcessApplication extends JakartaServletProcessApplication {

}
