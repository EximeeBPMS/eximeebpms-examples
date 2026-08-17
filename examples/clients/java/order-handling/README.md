# EximeeBPMS External Task Client (Java) Example

In this tutorial you will learn how to use the External Task client for Java.

In a nutshell you will be guided through the following steps:
* Starting the EximeeBPMS Runtime
* Modeling and Deploying a process with the Camunda Modeler
* Bootstrapping the External Task client
* Monitor the process in EximeeBPMS Cockpit

## Prerequisites
* [Java JDK 11+](https://www.oracle.com/java/technologies/downloads/#java11)
* [Apache Maven](https://maven.apache.org/download.cgi)
* [Camunda Modeler](https://camunda.com/download/modeler/)
* [EximeeBPMS Runtime](https://docs.eximeebpms.org/manual/latest/installation/)
* EximeeBPMS External Task Client

First, make sure you have downloaded and installed all the necessary prerequisites, 
and the running platform is [compatible](https://docs.eximeebpms.org/manual/latest/user-guide/ext-client/compatibility-matrix/) with the client version.

## Start the EximeeBPMS Runtime
* Microsoft Windows users need to run the `start.bat` file
* Users of Unix based operating systems need to run the `start.sh` file

## Deploy a Process

Next, we want to deploy a model to the EximeeBPMS Runtime with the following steps:

* Download the BPMN 2.0 XML of that model [here](./order-handling.bpmn).
* Open the model in the Camunda Modeler.
* Click on the "Deploy" icon ![Camunda Modeler – Deploy Button](./img/deploy-icon.png).
* Select "Deploy Current Diagram". 
* Select a deployment name of your choice.

To complete the deployment, click on the "Deploy" button.
Your model is now ready to be executed by the **EximeeBPMS Process Engine**.
Start an instance of it in [EximeeBPMS Tasklist](http://localhost:8080/eximeebpms/app/tasklist).

## Monitor the Process in EximeeBPMS Cockpit
Open [EximeeBPMS Cockpit](http://localhost:8080/eximeebpms/app/cockpit) click in the top navigation on "Processes" and then
on the process "Order Process". You should see the process with the activity instances.

## Set Up a Project
In this step we will set up the External Task client.

You can create a new Maven project using your IDE, or run the following command:

```sh
mvn archetype:generate \
    -DgroupId=org.eximeebpms.bpm \
    -DartifactId=order-handling \
    -DarchetypeArtifactId=maven-archetype-quickstart \
    -DinteractiveMode=false
```

Add the `eximeebpms-external-task-client` dependency to the project's `pom.xml`:
```xml
<dependency>
  <groupId>org.eximeebpms.bpm</groupId>
  <artifactId>eximeebpms-external-task-client</artifactId>
  <version>${version}</version>
</dependency>
```

Create a main class and add the following lines:
```java
    // bootstrap the client
    ExternalTaskClient client = ExternalTaskClient.create()
      .baseUrl("http://localhost:8080/engine-rest")
      .asyncResponseTimeout(1000)
      .customizeHttpClient(httpClientBuilder -> {
        httpClientBuilder.setDefaultRequestConfig(RequestConfig.custom()
            .setResponseTimeout(Timeout.ofSeconds(15))
            .build());
      })
      .build();

    // subscribe to the topic
    client.subscribe("invoiceCreator")
      .handler((externalTask, externalTaskService) -> {

        // instantiate an invoice object
        Invoice invoice = new Invoice("A123");

        // create an object typed variable with the serialization format XML
        ObjectValue invoiceValue = ClientValues
          .objectValue(invoice)
          .serializationDataFormat("application/xml")
          .create();

        // add the invoice object and its id to a map
        Map<String, Object> variables = new HashMap<>();
        variables.put("invoiceId", invoice.id);
        variables.put("invoice", invoiceValue);

        // select the scope of the variables
        boolean isRandomSample = Math.random() <= 0.5;
        if (isRandomSample) {
          externalTaskService.complete(externalTask, variables);
        } else {
          externalTaskService.complete(externalTask, null, variables);
        }

        System.out.println("The External Task " + externalTask.getId() +
          " has been completed!");

      }).open();
    
    client.subscribe("invoiceArchiver")
      .handler((externalTask, externalTaskService) -> {
        TypedValue typedInvoice = externalTask.getVariableTyped("invoice");
        Invoice invoice = (Invoice) typedInvoice.getValue();
        System.out.println("Invoice on process scope archived: " + invoice);
        externalTaskService.complete(externalTask);
      }).open();
```

Create an `Invoice` class and add the following lines:
```java
public class Invoice {
  
  public String id;

  public Invoice(String id) {
    this.id = id;
  }

  public Invoice() {
  }

  @Override
  public String toString() {
    return "Invoice [id=" + id + "]";
  }

}
```

Now, just run your application. The client starts to continuously fetch and lock for External Task instances.

You should see a similar result in your console window:
```sh
The External Task 5baf2670-1bad-11ec-9048-04d3b0c25ec0 has been completed!
Invoice on process scope archived: Invoice [id=A123]
...
```
