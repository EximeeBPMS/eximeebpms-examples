Order Confirmation Rules
========================

This is a sample for the [EximeeBPMS platform](https://eximeebpms.org) on [Jakarta EE](https://jakarta.ee/) demonstrating integration with [JBoss Drools](http://www.jboss.org/drools/).

![Order Confirmation Rules Screenshot][2]

# What will you learn?

1. How to build an simple JSF application including a simple BPMN 2.0 Process on a Jakarta EE environment
1. How to use [Drools](http://www.jboss.org/drools/) to implement business rules in your processes
1. How to create [Arquillian](http://arquillian.org) integration tests for your process application

# The Process

![Order Confirmation Process][1]

# Getting Started

1. Download the [EximeeBPMS platform](https://eximeebpms.org) distribution for WildFly from [here](https://eximeebpms.org/download/), install it and start it.
1. Make sure you have a JDK 17+ and Maven installed.
1. Clone this repository.
1. Build the application with `mvn package`.
1. Optional: to run the Arquillian integration test against the running server, do `mvn failsafe:integration-test`.
1. Copy the generated WAR artifact to the WildFly deployment directory `<EXIMEEBPMS_HOME>/server/wildfly-<version>/standalone/deployments/`.
1. Point your browser to `http://localhost:8080/order-confirmation-rules/` and enjoy!

# Further Resources

* See [this blog post](http://www.bpm-guide.de/2011/11/14/activiti-drools-wjax-2011/) including a screencast (in German) from talk at [WJAX](http://jax.de/) where this sample is presented.

For help, [contact us](https://eximeebpms.org/contact/).

[1]: src/main/webapp/resources/img/OrderConfirmation.png
[2]: src/main/webapp/resources/img/order-confirmation-rules-screenshot.png
