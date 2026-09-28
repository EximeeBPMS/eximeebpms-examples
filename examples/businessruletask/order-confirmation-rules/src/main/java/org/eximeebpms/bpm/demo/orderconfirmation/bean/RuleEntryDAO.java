package org.eximeebpms.bpm.demo.orderconfirmation.bean;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.eximeebpms.bpm.demo.orderconfirmation.model.DiscountRuleEntry;

@Named
@Stateless
public class RuleEntryDAO {

  @PersistenceContext
  private EntityManager entityManager;
  
  @SuppressWarnings("unchecked")
  @Produces
  @Named("ruleList")
  public List<DiscountRuleEntry> findAllDiscountRuleEntries() {
    return entityManager.createQuery("SELECT obj from " + DiscountRuleEntry.class.getSimpleName() + " obj").getResultList();
  }

  public void save(DiscountRuleEntry discountRuleEntry) {
    entityManager.persist(discountRuleEntry);
  }

  public void update(DiscountRuleEntry discountRuleEntry) {
    entityManager.merge(discountRuleEntry);
  }

  public DiscountRuleEntry findDiscountRuleEntry(Long entryId) {
    return entityManager.find(DiscountRuleEntry.class, entryId);
  }
  
}
