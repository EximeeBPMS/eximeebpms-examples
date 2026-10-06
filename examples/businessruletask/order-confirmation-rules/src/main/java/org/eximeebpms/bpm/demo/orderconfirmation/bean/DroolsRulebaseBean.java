package org.eximeebpms.bpm.demo.orderconfirmation.bean;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.drools.template.ObjectDataCompiler;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.runtime.KieSession;

import org.eximeebpms.bpm.demo.orderconfirmation.model.DiscountRuleEntry;

@Named
@ApplicationScoped
public class DroolsRulebaseBean {

  private String droolsRulebaseAsDrl;

  private KieBase knowledgeBase;

  @Inject
  private RuleEntryDAO rulesDAO;

  public void updateRulebase() {
    generateRules();
    createKnowledgebase();
  }

  private void generateRules() {
    List<DiscountRuleEntry> ruleEntries = rulesDAO.findAllDiscountRuleEntries();

    InputStream is = this.getClass().getResourceAsStream("/test.drt");
    droolsRulebaseAsDrl = new ObjectDataCompiler().compile(ruleEntries, is);
  }

  public void createKnowledgebase() {
    KieServices kieServices = KieServices.Factory.get();
    KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
    kieFileSystem.write("src/main/resources/discount-rules.drl",
        droolsRulebaseAsDrl.getBytes(StandardCharsets.UTF_8));

    KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem).buildAll();
    List<Message> errors = kieBuilder.getResults().getMessages(Message.Level.ERROR);
    if (!errors.isEmpty()) {
      StringBuilder buf = new StringBuilder();
      for (Message error : errors) {
        buf.append(error).append("; ");
      }
      throw new IllegalStateException("Rulebase is invalid: " + buf + "\n" + droolsRulebaseAsDrl);
    }
    knowledgeBase = kieServices.newKieContainer(kieBuilder.getKieModule().getReleaseId()).getKieBase();
  }

  public KieSession createNewWorkingMemory() {
    return getKnowledgeBase().newKieSession();
  }

  private KieBase getKnowledgeBase() {
    if (knowledgeBase == null) {
      updateRulebase();
    }
    return knowledgeBase;
  }

  public String getDroolsRulebaseAsDrl() {
    return droolsRulebaseAsDrl;
  }

  public String getDroolsRulebaseDrlHtml() {
    if (droolsRulebaseAsDrl == null) {
      return "";
    } else {
      return droolsRulebaseAsDrl.replaceAll("  ", "&nbsp;").replaceAll("\n", "<br/>");
    }
  }
}
