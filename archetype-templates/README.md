# EximeeBPMS Maven Archetypes

These are project templates for [EximeeBPMS](https://docs.eximeebpms.org), which enable a quickstart for developing process applications.

> **Note:** these archetypes are not yet published to Maven Central - `mvn archetype:generate`
> against a remote catalog will not find them yet. Clone this repository and run
> `mvn install` in `archetype-templates/` first, or generate a project directly from the
> corresponding [rendered sample](../archetype-samples) instead. Publishing is mechanically
> ready (see `.github/workflows/release-archetypes.yml`) but no release has been run yet.

## Template repositories
We provide a [rendered sample](../archetype-samples) for every EximeeBPMS Archetype. Each one contains a project generated from one specific archetype.

With every new release of the Archetypes, we will update those repositories with a new version as well. This allows to investigate possible update paths from one EximeeBPMS version to another and also enables you to simply update your existing project by pulling in the latest changes.

## Build from Source

A local build of all archetypes can be achieved with `mvn clean source:jar install` in the root directory. 
You can also build separate archetypes in their respective modules with the same command.

Besides, a couple of utility scripts that can aid in development can be found in the `utilities` directory.

## Full Documentation

The complete documentation of the Maven Archetypes is provided as part of the [EximeeBPMS User Guide](https://docs.eximeebpms.org/manual/latest/user-guide/process-applications/maven-archetypes/).

## License

The source files in this repository are made available under the [Apache License Version 2.0](./LICENSE).
