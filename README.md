# EximeeBPMS Examples

A consolidated collection of examples, Maven archetypes, and testing tools for
[EximeeBPMS](https://docs.eximeebpms.org), forked and rebranded from
Camunda's own equivalent repositories.

This repository merges five originally-independent upstream sources into one:

| Directory | Origin | What it is |
|---|---|---|
| [`examples/`](examples) | `camunda/camunda-bpm-examples` | The main example collection: process engine plugins, DMN model API usage, multi-tenancy, testing, webapp integrations, and more. |
| [`archetype-templates/`](archetype-templates) | `camunda/camunda-archetypes` | The Maven Archetype *template sources* (Velocity-templated) used to scaffold new EximeeBPMS process applications via `mvn archetype:generate`. |
| [`archetype-samples/`](archetype-samples) | `camunda/camunda-bpm-archetype-{engine-plugin,cockpit-plugin,servlet-war,ejb-war,spring-boot,servlet-war-demo,spring-boot-demo}` | Ready-made, already-*rendered* sample projects — one per archetype in `archetype-templates/` — showing what running that archetype actually produces, without needing to generate it yourself. |
| [`assert-scenario/`](assert-scenario) | `camunda/camunda-bpm-assert-scenario` | `eximeebpms-bpm-assert-scenario`: a testing library for specifying process-scenario behavior at wait states, plus its own runner/report/cucumber integration modules and worked example. |
| [`mockito/`](mockito) | `camunda-community-hub/camunda-platform-7-mockito` | `eximeebpms-bpm-mockito`: a Mockito extension providing fluent mock/fake builders for `JavaDelegate`, `TaskListener`, `ExecutionListener`, and the engine's service/query interfaces. |

Each subdirectory is (and remains) independently buildable — there is no
single top-level Maven reactor tying all five together, since they serve
different purposes and had no shared build in their original repositories
either.

## Status

All five groups have been rebranded (`org.camunda`/`com.camunda` →
`org.eximeebpms`/`com.eximeebpms` throughout) and functionally verified:

- `examples/`: `mvn clean compile` green across the ~41-module active
  reactor; `mvn test` 42/44 modules pass (2 confirmed, documented,
  environment-specific failures — see `examples/README.md`).
- `archetype-templates/`: all 7 archetypes verified end-to-end via
  `mvn install` (`archetype:integration-test` generates a real project from
  each and runs its tests against the live, renamed engine).
- `archetype-samples/`: all 7 rendered samples compile clean.
- `assert-scenario/`: compiles clean; full reactor builds with real tests
  executing against the live engine.
- `mockito/`: forked from the exact version (`5.15.0`) the examples depend
  on, rebranded, and adapted for interface methods added to the engine
  since that release; 114 tests pass, 0 failures.

A further, eleventh source is still being rebranded separately and is
**not yet included here** (see `docs-camunda-repository-references.md`
in `eximeebpms-factory` for its status).

## License

Apache License, Version 2.0 — see [LICENSE](LICENSE) and [NOTICE](NOTICE)
for the origin and copyright of each consolidated source.
