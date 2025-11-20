# Red Black Tree in Java

## Exec

To easily execute, the main class needs to be provided in the `pom.xml`:
```xml
  <properties>
    <exec.mainClass>com.xayon40_12.app.App</exec.mainClass>
  </properties>
```

Then, Maven can execute the main:
```bash
mvn compile exec:java
```

### Disable maven unsafe warnings

Maven uses unsafe commands that are currently deprecated in recent Java. To hide then, add `--sun-misc-unsafe-memory-access=allow` to `.mvn/jvm.config`.

### Make unsafe conversions as errors

In the `pow.xml`, add inside the maven compiler plugin
```xml
<plugin>
  <artifactId>maven-compiler-plugin</artifactId>
  ...
</plugin>
```
the following configuration
```xml
  <configuration>
      <compilerArgs>
          <arg>-Xlint:unchecked</arg>
          <arg>-Werror</arg>
      </compilerArgs>
  </configuration>
```

### Disable `[Info]` while showing `[Warning]`

To show `[Warning]` but no `[Info]` in the maven output, add `-Dorg.slf4j.simpleLogger.defaultLogLevel=warn` to `.mvn/jvm.config`.

