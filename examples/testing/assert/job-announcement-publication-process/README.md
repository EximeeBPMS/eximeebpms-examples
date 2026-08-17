# Executing EximeeBPMS Assert tests

This project demonstrates how to setup a minimal project to run EximeeBPMS Assert tests

## Prerequisites
* Java 17/21

## How to run it

1. Checkout the project with Git
2. Read and run the [unit tests][1]

### Running the test with maven

In order to run the testsuite with maven you can use:

```
mvn clean test
```

## Further reading
If you want to read more about [EximeeBPMS Assert][assert], go to the [testing user guide](https://docs.eximeebpms.org/manual/latest/user-guide/testing/) in the EximeeBPMS docs.


[assert]: https://github.com/EximeeBPMS/eximeebpms/tree/main/test-utils/assert
[1]: src/test/java/org/eximeebpms/bpm/engine/test/assertions/examples
