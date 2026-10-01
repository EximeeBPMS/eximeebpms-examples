package org.eximeebpms.bpm.demo.orderconfirmation.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="ORDERCONF_CUSTOMER")
public class Customer implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
  private Long id;

  @SuppressWarnings("unused")
  @Version
  private Long version;

  @NotNull
  private String company;

  @NotNull
  @Pattern(regexp = ".+@.+\\.[a-z]+", message = "Please provide a vaild email")
  private String email;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Customer [id=" + id + ", company=" + company + ", email=" + email + "]";
  }
}
