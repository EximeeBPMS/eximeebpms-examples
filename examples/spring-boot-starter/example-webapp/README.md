# Spring Boot Web application with EximeeBPMS Webapps

This example demonstrates how you can build Spring Boot Web application having following configured:
* Embedded EximeeBPMS engine
* EximeeBPMS web applications automatically deployed
* Process application and one BPMN process deployed
* Admin user configured with login and password configured in `application.yaml`

It also contains a simple integration test, showing how this can be tested.

## Prerequisites
* Java 17/21

## How is it done

1. To embed the EximeeBPMS engine with webapps you must add following dependency to your `pom.xml`:

```xml
...
<dependency>
  <groupId>org.eximeebpms.bpm.springboot</groupId>
  <artifactId>eximeebpms-bpm-spring-boot-starter-webapp</artifactId>
  <version>7.24.0</version>
</dependency>
...
```

2. With Spring Boot you usually create an "application" class annotated with `@SpringBootApplication`. In order to have an EximeeBPMS process application
registered, you can simply add an annotation `@EnableProcessApplication` to the same class and also include a `processes.xml` file in your `META-INF` folder:

```java
@SpringBootApplication
@EnableProcessApplication
public class WebappExampleApplication {

  public static void main(String... args) {
    SpringApplication.run(WebappExampleApplication.class, args);
  }
}
```

3. You can also put BPMN and DMN files in your classpath, they will be automatically deployed and registered within a process application.


## Run the application and use EximeeBPMS Webapps

You can build the application with `mvn clean install` and then run it with `java -jar` command.

Then you can access EximeeBPMS Webapps in browser: `http://localhost:8080` (provide login/password from `application.yaml`, default: demo/demo)

