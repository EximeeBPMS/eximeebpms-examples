# BPMN parsing using the BPMN model API

This example demonstrates how to use the [EximeeBPMS BPMN model API][bpmn-model] to parse
a BPMN process. It shows how simple you can access attributes, child elements and
extension elements. Also it illustrates how to use references between model elements
to traverse the model.

Please have a look at the source code and comments of the [unit test case][test-case] to get
an impression about this feature of the [EximeeBPMS BPMN model API][bpmn-model].

Also be aware that you can use:
* [EximeeBPMS XML model API][xml-model] to process XML in a generic way
* [EximeeBPMS DMN model API][dmn-model] to handle DMN models

## How to use it?

1. Checkout the project with Git
2. Read and run the [unit test case][test-case]

[bpmn-model]: https://github.com/EximeeBPMS/eximeebpms/tree/main/model-api/bpmn-model
[xml-model]: https://github.com/EximeeBPMS/eximeebpms/tree/main/model-api/xml-model
[dmn-model]: https://github.com/EximeeBPMS/eximeebpms/tree/main/model-api/dmn-model
[test-case]: src/test/java/org/eximeebpms/bpm/example/modelapi/ParseBpmnTest.java