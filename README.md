# Data Retrieval and search filter service

## Running the application

```sh
gradle run
```

## Building the application

- `gradle build` will generate an AOT optimised build(?)
- `gradle nativeCompile` will build a GraalVM Native Executable (you need to have GraalVM installed for this to work)

[https://micronaut-projects.github.io/micronaut-gradle-plugin/latest/](https://micronaut-projects.github.io/micronaut-gradle-plugin/latest/)

### Building a Container Image

The instruction here will generate an AOT optimised native image, which has superior
time to first request performance ([link](https://guides.micronaut.io/latest/micronaut-docker-image-gradle-java.html#comparisons)), however, it might take a while to build as it attempts to apply multiple optimisation to the application.

[https://guides.micronaut.io/latest/micronaut-docker-image-gradle-java.html](https://guides.micronaut.io/latest/micronaut-docker-image-gradle-java.html)

#### Docker

If you are using docker, you can use the command provided by the Micronaut gradle plugin to build the container.

1. To build the container, execute `gradle optimizedDockerBuildNative`

2. To run the container, execute `docker run -d --rm -p 8080:8080 imageupload:latest`
   - `-d`: Detach the container from the shell (run the container in the background).
   - `-rm`: Automatically remove the container when it exits.
   - `-p 8080:8080`: Expose port 8080 of the container to port 8080 on the host machine.

#### Podman

Things are not as straight forward if you are using podman.

1. Generate the required container build file with `gradle optimizedBuildNativeLayersTask optimizedDockerPrepareContext`

2. Change your working directory to `build/docker/native-optimized` with `cd build/docker/native-optimized`

3. Build the container with `podman build -t imageupload ./ -f DockerfileNative`

4. Run the container with `podman run -d --rm -p 8080:8080 imageupload:latest`

## Dokka

Dokka is the Javadoc equivalent in Kotlin.

```sh
gradle dokkaHtml
```

Open `build/dokka/html/index.html` in your browser to view the generated documentation.

KDoc syntax: [https://kotlinlang.org/docs/kotlin-doc.html](https://kotlinlang.org/docs/kotlin-doc.html)

### Accessing the OpenAPI documentation, Swagger UI

Start the server by following the instruction above and go to the `/swagger-ui/index.html` endpoint to access the page.

## Testing the application

```sh
gradle test
```

The test report is located in `build/reports/tests/test/index.html`. Open this file in your browser to view the report.

## Versioning

Please use [Semantic Versioning (Semver)](https://semver.org/) to name releases.

---

## Micronaut 4.0.4 Documentation

- [User Guide](https://docs.micronaut.io/4.0.4/guide/index.html)
- [API Reference](https://docs.micronaut.io/4.0.4/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/4.0.4/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)

---

- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
- [Micronaut Gradle Plugin documentation](https://micronaut-projects.github.io/micronaut-gradle-plugin/latest/)
- [GraalVM Gradle Plugin documentation](https://graalvm.github.io/native-build-tools/latest/gradle-plugin.html)

## Feature ksp documentation

- [Micronaut Kotlin Symbol Processing (KSP) documentation](https://docs.micronaut.io/latest/guide/#kotlin)

- [https://kotlinlang.org/docs/ksp-overview.html](https://kotlinlang.org/docs/ksp-overview.html)

## Feature serialization-jackson documentation

- [Micronaut Serialization Jackson Core documentation](https://micronaut-projects.github.io/micronaut-serialization/latest/guide/)

## Feature micronaut-aot documentation

- [Micronaut AOT documentation](https://micronaut-projects.github.io/micronaut-aot/latest/guide/)

## Feature reactor documentation

- [Micronaut Reactor documentation](https://micronaut-projects.github.io/micronaut-reactor/snapshot/guide/index.html)

## Feature swagger-ui documentation

- [Micronaut Swagger UI documentation](https://micronaut-projects.github.io/micronaut-openapi/latest/guide/index.html)

- [https://swagger.io/tools/swagger-ui/](https://swagger.io/tools/swagger-ui/)

## Feature openapi documentation

- [Micronaut OpenAPI Support documentation](https://micronaut-projects.github.io/micronaut-openapi/latest/guide/index.html)

- [https://www.openapis.org](https://www.openapis.org)
