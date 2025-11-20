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
mvn -q exec:java
```
where `-q` removes the `[INFO]` from Maven to only see the output of the jvm.

## Unsafe warnings

Maven uses unsafe commands that are currently deprecated in recent Java. To hide then, create a file `.mvn/jvm.config` and add `--sun-misc-unsafe-memory-access=allow` to it.
