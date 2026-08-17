EximeeBPMS examples
====================

> Looking for the "invoice" example contained in the distribution? The upstream Camunda equivalent is here: https://github.com/camunda/camunda-bpm-platform/tree/master/examples/invoice — no EximeeBPMS port exists yet.

EximeeBPMS examples is a collection of focused usage examples for [EximeeBPMS](https://github.com/EximeeBPMS/eximeebpms), intended to get you started quickly. This repository consolidates the examples forked from Camunda's own `camunda-bpm-examples` (and several sibling example repositories). The historical per-version Camunda tags (`7.1`–`7.24`) this repository used to track no longer apply; the sources here work with the current EximeeBPMS release.

## Overview

* [Getting Started with EximeeBPMS](#getting-started-with-eximeebpms)
* [BPMN 2.0 & Process Implementation](#bpmn-20--process-implementation-examples)
* [Deployment & Project Setup](#deployment--project-setup-examples)
* [Process Engine Plugin](#process-engine-plugin-examples)
* [Bpmn 2.0 Model API](#bpmn-20-model-api-examples)
* [Cockpit](#cockpit-examples)
* [Tasklist](#tasklist-examples)
* [Multi-Tenancy](#multi-tenancy-examples)
* [Spin](#spin-examples)
* [DMN](#dmn-examples)
* [Process Instance Migration](#process-instance-migration-examples)
* [SDK-JS Examples](#sdk-js-examples)
* [Authentication](#authentication)
* [Spring Boot Starter examples](#spring-boot-starter-examples)
* [Quarkus Extension Examples](#quarkus-extension-examples)
* [External Task Client](#external-task-client)
* [External Task Client Spring](#external-task-client-spring)
* [External Task Client Spring Boot](#external-task-client-spring-boot)
* [Testing](#testing)

### Getting Started with EximeeBPMS

| Name                                                                                           | Container          |
|------------------------------------------------------------------------------------------------|--------------------|
| [Simple Process Applications](https://docs.eximeebpms.org/get-started/quick-start/)             | All                |
| [EximeeBPMS and the Spring Framework](https://docs.eximeebpms.org/get-started/spring/)          | Tomcat             |
| [Process Applications with Jakarta EE](https://docs.eximeebpms.org/get-started/javaee/)         | WildFly            |

### BPMN 2.0 & Process Implementation Examples

| Name                                                                                                             | Container         | Keywords                  |
|------------------------------------------------------------------------------------------------------------------|-------------------|---------------------------|
| [Service Task REST HTTP](/servicetask/rest-service)                                                              | Unit Test         | Rest Scripting, classless |
| [Service Task SOAP HTTP](/servicetask/soap-service) [^1]                                                         | Unit Test         | SOAP Scripting, classless |
| [Service Task SOAP CXF HTTP](/servicetask/soap-cxf-service) [^1]                                                 | Unit Test         | SOAP, CXF, Spring, Spin   |
| [Service Invocation Synchronous](/servicetask/service-invocation-synchronous)                                    | Unit Test         | Java Delegate, Sync       |
| [Service Invocation Asynchronous](/servicetask/service-invocation-asynchronous)                                  | Unit Test         | Signal, Async             |
| [User Task Assignment Email](/usertask/task-assignment-email) [^1][^2]                                           | All               | Email, Usertask           |
| [User Task Form Embedded](/usertask/task-form-embedded) [^2]                                                     | All               | Html, Form, Usertask      |
| [User Task Form Embedded - Serialized Java Object](/usertask/task-form-embedded-serialized-java-object) [^1][^2] | All               | Html, Form, Usertask      |
| [User Task Form Embedded - JSON](/usertask/task-form-embedded-json-variables) [^2]                               | All               | Html, Form, Usertask      |
| [User Task Form Embedded - Bpmn Elements](/usertask/task-form-embedded-bpmn-events) [^2]                         | All               | Html, Form, Usertask      |
| [User Task Form Embedded - React](/usertask/task-form-embedded-react) [^2]                                       | All               | Html, Form, Usertask      |
| [User Task Form - EximeeBPMS Forms](/usertask/task-eximeebpms-forms) [^2]                                              | All               | Html, Form, Usertask      |
| [User Task Form Generated](/usertask/task-form-generated) [^1][^2]                                               | All               | Html, Form, Usertask      |
| [User Task Form JSF](/usertask/task-form-external-jsf) [^1][^2]                                                  | JavaEE Containers | JSF, Form, Usertask       |
| [Script Task XSLT](/scripttask/xslt-scripttask)                                                                  | Unit Test         | XSLT Scripttask           |
| [Script Task XQuery](/scripttask/xquery-scripttask) [^1]                                                         | Unit Test         | XQuery Scripttask         |
| [Start Event - Message](/startevent/message-start)                                                               | Unit Test         | Message Start Event       |
| [Start Process - SOAP CXF](/startevent/soap-cxf-server-start) [^1]                                               | War               | SOAP, CXF, Spring         |

### Deployment & Project Setup Examples

| Name                                                                                            | Container                |  Keywords                 |
|-------------------------------------------------------------------------------------------------|--------------------------|---------------------------|
| [Process Application - Servlet](deployment/servlet-pa)                                          | Jakarta EE Containers    | War, Servlet              |
| [Process Application - EJB](deployment/ejb-pa) [^1]                                             | JavaEE Containers        | Ejb, War                  |
| [Process Application - Jakarta EJB](deployment/ejb-pa-jakarta)                                  | Jakarta EE Containers    | Ejb, War                  |
| [Process Application - Spring 6 Servlet - WildFly](deployment/spring-servlet-pa-wildfly)        | WildFly                  | Spring, Servlet, War      |
| [Process Application - Spring 6 Servlet - Embedded Tomcat](deployment/spring-servlet-pa-tomcat) | Tomcat 10                | Spring, Servlet, War      |
| [Embedded Spring 6 with embedded REST](deployment/embedded-spring-rest)                         | vanilla Apache Tomcat 10 | Spring, Rest, Embedded    |
| [Plain Spring 6 Web application - WildFly](deployment/spring-wildfly-non-pa)                    | WildFly                  | Spring, Jndi, War         |
| [Process Application - Spring Boot](deployment/spring-boot) [^1]                                | Spring Boot              | Spring                    |

### Process Engine Plugin Examples

| Name                                                                                            | Container            |  Keywords                                   |
|-------------------------------------------------------------------------------------------------|----------------------|---------------------------------------------|
| [BPMN Parse Listener](process-engine-plugin/bpmn-parse-listener)                                | Unit Test            | Process Engine Plugin, Bpmn Parse Listener  |
| [BPMN Parse Listener on User Task](process-engine-plugin/bpmn-parse-listener-on-user-task) [^1] | Unit Test            | Process Engine Plugin, Bpmn Parse Listener  |
| [Command Interceptor - Blocking](process-engine-plugin/command-interceptor-blocking)            | Unit Test            | Maintenance, Interceptor, Configuration     |
| [Custom History Level](process-engine-plugin/custom-history-level)                              | Unit Test            | Process Engine Plugin, Custom History Level |
| [Failed Job Retry Profile](process-engine-plugin/failed-job-retry-profile)                      | Unit Test            | Process Engine Plugin, Failed Job Retry     |

### Bpmn 2.0 Model API Examples

| Name                                                                 | Container            | Keywords                  |
|----------------------------------------------------------------------|----------------------|---------------------------|
| [Generate JSF forms](/bpmn-model-api/generate-jsf-form) [^1]         | JavaEE Containers    | JSF, Usertask             |
| [Generate BPMN process](/bpmn-model-api/generate-process-fluent-api) | Unit Test            | Fluent API                |
| [Parse BPMN model](/bpmn-model-api/parse-bpmn)                       | Unit Test            | BPMN                      |

### Cockpit Examples

| Name                                                                                                           | Keywords                                  |
|----------------------------------------------------------------------------------------------------------------|-------------------------------------------|
| [Fullstack (ReactJS 16.x & Java) "Count Processes" Cockpit Plugin](/cockpit/cockpit-fullstack-count-processes) | Plugin, Custom Script, Fullstack, ReactJS |
| [Angular "Open Usertasks" Cockpit Tab](/cockpit/cockpit-angular-open-usertasks) [^1]                           | Plugin, Custom Script, Angular            |
| [AngularJS 1.x "Search Processes" Cockpit Plugin](/cockpit/cockpit-angularjs-search-processes) [^1]            | Plugin, Custom Script, AngularJS          |
| [ReactJS "Involved Users" Cockpit Plugin](/cockpit/cockpit-react-involved-users)                               | Plugin, Custom Script, ReactJS            |
| ["Cats" Cockpit Plugin](/cockpit/cockpit-cats) [^1]                                                            | Plugin, Custom Script                     |
| ["Diagram interactions" Cockpit Plugin](/cockpit/cockpit-diagram-interactions)                                 | Plugin, Custom Script                     |
| ["Open Incidents" Cockpit Plugin](/cockpit/cockpit-open-incidents) [^1]                                        | Plugin, Custom Script                     |
| ["Request Interceptor" Cockpit Script](/cockpit/cockpit-request-interceptor) [^1]                              | Plugin, Custom Script                     |
| [bpmn-js Cockpit module](/cockpit/cockpit-bpmn-js-module) [^1]                                                 | Plugin, Custom Script, bpmn-js            |
| [bpmn-js Cockpit module - bundled](/cockpit/cockpit-bpmn-js-module-bundled)                                    | Plugin, Custom Script, bpmn-js, rollup    |

### Tasklist Examples

| Name                                                                                                                                                                    | Keywords                  |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------|
| [Create Standalone Task - client side](https://github.com/EximeeBPMS/eximeebpms/tree/main/webapps/frontend/ui/tasklist/plugins/standaloneTask/app)             | Plugin                    |
| [Create Standalone Task - server side](https://github.com/camunda/camunda-bpm-platform/blob/master/webapps/assembly/src/main/java/org/camunda/bpm/tasklist/impl/plugin) | Plugin                    |
| [Javascript Only Plugin](/tasklist/cats-plugin)                                                                                                                         | Plugin, Custom Script     |
| [JQuery 3.4 Behavior Patch](/tasklist/jquery-34-behavior) [^1]                                                                                                          | Plugin, Custom Script     |


### SDK-JS Examples

| Name                                           | Environment | Keywords                    |
|------------------------------------------------|-------------|-----------------------------|
| [SDK JS forms](/sdk-js/browser-forms) [^1][^2] | Browser     | HTML, task, form, SDK       |

### Multi-Tenancy Examples

| Name                                                                                                                       | Container | Keywords      |
|----------------------------------------------------------------------------------------------------------------------------|-----------|---------------|
| [Multi-Tenancy with Database Schema Isolation](multi-tenancy/schema-isolation)                                             | Wildfly   | Multi-Tenancy |
| [Multi-Tenancy with Tenant Identifiers for Embedded Process Engine](multi-tenancy/tenant-identifier-embedded)              | Unit Test | Multi-Tenancy |
| [Multi-Tenancy with Tenant Identifiers for Shared Process Engine](multi-tenancy/tenant-identifier-shared)                  | All       | Multi-Tenancy |
| [Multi-Tenancy with Tenant Identifiers and Shared Process Definitions](multi-tenancy/tenant-identifier-shared-definitions) | Unit Test | Multi-Tenancy |

### Spin Examples

| Name                                                                                                                                           | Container          | Keywords                           |
|------------------------------------------------------------------------------------------------------------------------------------------------|--------------------|------------------------------------|
| [Global Data Format Configuration to Customize JSON serialization](spin/dataformat-configuration-global)                                       | Unit Test          | Spin, Configuration                |
| [Process-Application-Specific Data Format Configuration to Customize JSON serialization](spin/dataformat-configuration-in-process-application) | Application Server | Spin, Configuration, Shared Engine |

### DMN Examples

| Name                                                                                  | Container | Keywords        |
|---------------------------------------------------------------------------------------|-----------|-----------------|
| [Embed Decision Engine - Dish Decision Maker](dmn-engine/dmn-engine-java-main-method) | Jar       | DMN, Embed      |
| [Decision Requirements Graph(DRG) Example](dmn-engine/dmn-engine-drg)                 | Jar       | DMN, DRG, Embed |

### Process Instance Migration Examples

| Name                                                                              | Container                             | Keywords        |
|-----------------------------------------------------------------------------------|---------------------------------------|-----------------|
| [Migration on Deployment of New Process Version](migration/migrate-on-deployment) | Application Server with Shared Engine | BPMN, Migration |

### Authentication

| Name                                              | Container                                                                  | Keywords                |
|---------------------------------------------------|----------------------------------------------------------------------------|-------------------------|
| [Basic Authentication](authentication/basic) [^1] | Spring boot with embedded engine, REST API and Basic Authentication filter |  Authentication         |

### Spring Boot Starter examples

| Name                                                              | Container                                              | Keywords                              |
|-------------------------------------------------------------------|--------------------------------------------------------|---------------------------------------|
| [Plain EximeeBPMS Engine](spring-boot-starter/example-simple)     | Jar                                                    | Spring Boot Starter                   |
| [Webapps](spring-boot-starter/example-webapp)                     | Spring boot with embedded engine and Webapps           | Spring Boot Starter, Webapps          |
| [REST API](spring-boot-starter/example-web)                       | Spring boot with embedded engine and Webapps           | Spring Boot Starter, REST API         |
| [Twitter](spring-boot-starter/example-twitter)                    | Spring boot with embedded engine and Webapps           | Spring Boot Starter, Webapps, Twitter |
| [Autodeployment](spring-boot-starter/example-autodeployment) [^1] | Spring boot with embedded engine and Webapps           | Spring Boot Starter                   |
| [REST API DMN](spring-boot-starter/example-dmn-rest) [^1]         | Spring boot with embedded engine and Webapps           | Spring Boot Starter, REST API         |

### Quarkus Extension Examples

| Name                                                              | Container                                                                  | Keywords                |
|-------------------------------------------------------------------|----------------------------------------------------------------------------|-------------------------|
| [Datasource Example](quarkus-extension/datasource-example)        | Uber-Jar                                                                   |  Quarkus Extension      |
| [Spin Plugin Example](quarkus-extension/spin-plugin-example)      | Uber-Jar                                                                   |  Quarkus Extension      |
| [Simple REST Example](quarkus-extension/simple-rest-example) [^1] | Uber-Jar                                                                   |  Quarkus Extension      |

### External Task Client

| Name                                                                                                                         | Environment                         | Keywords                          |
|------------------------------------------------------------------------------------------------------------------------------|-------------------------------------|-----------------------------------|
| [Order Handling - Java](./clients/java/order-handling)                                                                       | Java External Task Client           | External Task Client, Servicetask |
| [Loan Granting - Java](./clients/java/loan-granting) [^1]                                                                    | Java External Task Client           | External Task Client, Servicetask |
| [Dataformat - Java](./clients/java/dataformat) [^1]                                                                          | Java External Task Client           | External Task Client, Servicetask |
| [Loan Granting - JavaScript](https://github.com/camunda/camunda-external-task-client-js/tree/master/examples/granting-loans) | JavaScript External Task Client     | External Task Client, Servicetask |
| [Order Handling - JavaScript](https://github.com/camunda/camunda-external-task-client-js/tree/master/examples/order)         | JavaScript External Task Client     | External Task Client, Servicetask |
 
### External Task Client Spring

| Name                                                                                           | Keywords                          |
|------------------------------------------------------------------------------------------------|-----------------------------------|
| [Loan Granting Example](./spring-boot-starter/external-task-client/loan-granting-spring) [^1]  | External Task Client, Servicetask |

### External Task Client Spring Boot

| Name                                                                                                                      | Container                                           | Keywords                                               |
|---------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------|--------------------------------------------------------|
| [Loan Granting w/ REST API & Webapp Example](./spring-boot-starter/external-task-client/loan-granting-spring-boot-webapp) | Spring Boot with embedded Client, REST API & Webapp | External Task Client, Servicetask, Spring Boot Starter |
| [Order Handling Example](./spring-boot-starter/external-task-client/order-handling-spring-boot) [^1]                      | Spring Boot with embedded Client                    | External Task Client, Servicetask, Spring Boot Starter |
| [Request Interceptor Example](./spring-boot-starter/external-task-client/request-interceptor-spring-boot) [^1]            | Spring Boot with embedded Client                    | External Task Client, Servicetask, Spring Boot Starter |

### Container Specifics

| Name                                                                  | Container | Keywords     |
|-----------------------------------------------------------------------|-----------|--------------|
| [Jackson Annotation Example for WildFly](wildfly/jackson-annotations) | Wildfly   | War, Servlet |

### Testing

| Name                                                                                                 | Keywords                 |
|------------------------------------------------------------------------------------------------------|--------------------------|
| [Assert](testing/assert/job-announcement-publication-process)                                        | Testing, Junit 4, Assert |
| [Assert and JUnit 5](testing/junit5/eximeebpms-bpm-junit-assert/)                                       | Testing, Junit 5, Assert |
| [Assert and Junit 5: configure a custom process engine](testing/junit5/eximeebpms-bpm-junit-use-engine) | Testing, Junit 5, Assert |

## Contributing

Have a look at our [contribution guide](https://github.com/EximeeBPMS/eximeebpms/blob/master/CONTRIBUTING.md) for how to contribute to this repository.

## License
The source files in this repository are made available under the [Apache License Version 2.0](./LICENSE).

[^1]: _This example is not actively maintained anymore._

[^2]: _Complete demo applications_
