# EximeeBPMS Assert Example for JUnit 5

This project contains simple examples of how to write a unit test for EximeeBPMS using the [JUnit 5 extension][junit5] and [EximeeBPMS Assert][assert].

The project contains the following files:

```
src/
├── main
│   ├── java
│   └── resources
└── test
    ├── java
    │   └── org
    │       └── eximeebpms
    │           └── bpm
    │               └── unittest                                               (1)
    │                   ├── ProcessEngineExtensionExtendWithTest.java
    │                   └── ProcessEngineExtensionRegisterExtensionTest.java
    └── resources
        ├── eximeebpms.cfg.xml                                                    (2)
        └── testProcess.bpmn                                                   (3)
```
Explanation:

* (1) A folder containing two java class. Each class contains a JUnit Test. They use the `ProcessEngineExtension` for bootstrapping the process engine. Each test demonstrates one way to set up the `ProcessEngineExtension`. Both tests also use [eximeebpms-bpm-assert][assert] to make your test life easier.
* (2) Configuration file for the process engine.
* (3) An example BPMN process.

## Prerequisites
* Java 17/21

## Running the test with maven

In order to run the testsuite with maven you can use:

```
mvn clean test
```

## Further reading
If you want to read more about [EximeeBPMS Assert][assert] or the [EximeeBPMS JUnit 5 extension], go to the [testing user guide](https://docs.eximeebpms.org/manual/latest/user-guide/testing/) in the EximeeBPMS docs.

[junit5]: https://github.com/EximeeBPMS/eximeebpms/tree/main/test-utils/junit5-extension
[assert]: https://github.com/EximeeBPMS/eximeebpms/tree/main/test-utils/assert