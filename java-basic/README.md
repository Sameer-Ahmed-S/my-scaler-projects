Java-Basic is a project generated from the IDE and used for learning the build process.

### Jar manifest add to build.gradle file
This make jar manifest available in the jar, jar stand for java archieve. It is similar to zip file or war file.

```
jar {
duplicatesStrategy = DuplicatesStrategy.EXCLUDE
manifest {
attributes (
'Class-Path' : configurations.runtimeClasspath
                                .collect { it.getName() }.join(' ') ,
'Main-Class' : 'org.scaler.Main'

        )
    }
    from {
        configurations.runtimeClasspath.collect { it.isDirectory() ? it : zipTree(it) }
    }
}
```

### Build the jar file 

```
 > .\gradlew.bat jar
 > java -jar .\build\libs\java-basic-1.0-SNAPSHOT.jar
```


### Libraries to call Http endpoints

- OkHttp 
- Retrofit -A type-safe HTTP client for Android and Java