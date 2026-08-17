# Spring 6 configured embedded process engine and REST API

This example demonstrates how to set up a web application, which

* Bundles the `eximeebpms-engine` JAR library
* Starts and configures a process engine in a Spring 6 Application context
* Bundles the `eximeebpms-engine-rest-jakarta` library
* Exposes the Process Engine API via REST

> **Note:** This project must be deployed on a vanilla Apache Tomcat 10 server, NOT the prepackaged distribution
> which can be downloaded from Maven Central (`org.eximeebpms.bpm.tomcat:eximeebpms-bpm-tomcat`).

## Requirements

* Java 17

## Why is this example interesting?

This example demonstrates how to perform a standalone embedded setup with a Web application which
bundles both the EximeeBPMS Process Engine and EximeeBPMS Engine REST JARs.

## Show me the important parts!

The Process Engine is configured in the Spring application context:

```xml
<bean id="processEngineConfiguration"
  class="org.eximeebpms.bpm.engine.spring.SpringProcessEngineConfiguration">
  <property name="processEngineName" value="default" />
  <property name="dataSource" ref="dataSource" />
  <property name="transactionManager" ref="transactionManager" />
  <property name="databaseSchemaUpdate" value="true" />
  <property name="jobExecutorActivate" value="false" />
  <property name="deploymentResources" value="classpath*:*.bpmn" />
</bean>

<bean id="processEngine" class="org.eximeebpms.bpm.engine.spring.ProcessEngineFactoryBean">
  <property name="processEngineConfiguration" ref="processEngineConfiguration" />
</bean>

<bean id="repositoryService" factory-bean="processEngine"
  factory-method="getRepositoryService" />
<bean id="runtimeService" factory-bean="processEngine"
  factory-method="getRuntimeService" />
<bean id="taskService" factory-bean="processEngine"
  factory-method="getTaskService" />
<bean id="historyService" factory-bean="processEngine"
  factory-method="getHistoryService" />
<bean id="managementService" factory-bean="processEngine"
  factory-method="getManagementService" />
```

A custom JAX-RS Application class deploys the REST Endpoints:

```java
public class RestProcessEngineDeployment extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> classes = new HashSet<>();

    classes.addAll(CamundaRestResources.getResourceClasses());
    classes.addAll(CamundaRestResources.getConfigurationClasses());

    return classes;
  }

}
```

Implement the REST Process Engine Provider SPI (provides the process engine to the REST application):

```java
public class RestProcessEngineProvider implements ProcessEngineProvider {

  public ProcessEngine getDefaultProcessEngine() {
    return ProcessEngines.getDefaultProcessEngine();
  }

  public ProcessEngine getProcessEngine(String name) {
    return ProcessEngines.getProcessEngine(name);
  }

  public Set<String> getProcessEngineNames() {
    return ProcessEngines.getProcessEngines().keySet();
  }

}
```

Add a file named:
    `src/main/resources/META-INF/services/org.eximeebpms.bpm.engine.rest.spi.ProcessEngineProvider`
which contains the name of the provider:
    `org.eximeebpms.bpm.example.loanapproval.rest.RestProcessEngineProvider`

Reference all required libraries in pom.xml:

```xml
<dependency>
  <groupId>org.eximeebpms.bpm</groupId>
  <artifactId>eximeebpms-engine</artifactId>
  <version>${version.eximeebpms}</version>
</dependency>

<dependency>
  <groupId>org.eximeebpms.bpm</groupId>
  <artifactId>eximeebpms-engine-spring-6</artifactId>
  <version>${version.eximeebpms}</version>
</dependency>

<dependency>
  <groupId>org.eximeebpms.bpm</groupId>
  <artifactId>eximeebpms-engine-rest-jakarta</artifactId>
  <version>${version.eximeebpms}</version>
  <classifier>classes</classifier>
</dependency>

<dependency>
  <groupId>org.jboss.resteasy</groupId>
  <artifactId>resteasy-core</artifactId>
  <version>${version.resteasy}</version>
</dependency>

<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-web</artifactId>
  <version>${spring.version}</version>
</dependency>

<dependency>
  <groupId>com.h2database</groupId>
  <artifactId>h2</artifactId>
  <version>${version.h2}</version>
</dependency>
```

## How to use it?

1. Build it with Maven.
2. Deploy it to a vanilla Apache Tomcat 10 server, NOT the prepackaged distribution (`org.eximeebpms.bpm.tomcat:eximeebpms-bpm-tomcat`)!
3. Access the [REST Endpoint](http://localhost:8080/eximeebpms-quickstart-embedded-spring-rest-1.0-SNAPSHOT/engine/default/process-definition)
