# Example: Equinox

## What

This example demonstrates the build of a simple OSGi console application containing a bundle that is written in Kotlin.

## Why

The console application is a minimal OSGi application. Therefore, this example provides a minimal starting point
for other OSGi projects that want to use Gradle and Kotlin. 

## How

### Build

To build the project enter the root directory of this example and run:
 ```bash
 gradle build
 ```

### Run

The final application will be assembled inside the `build/app/` directory and will contain the OSGi framework Equinox and
several other bundles. To start the console application enter:

```bash
java -jar build/app/org.eclipse.osgi.jar -console -consoleLog
```

Now, you are inside the OSGi shell. This should be indicated by the `g!` at the start of the line. To check the current
state of the OSGi application enter `ss`. You will see a list of bundles, like this one:

```bash
g! ss
"Framework is launched."


id	State       Bundle
0	ACTIVE      org.eclipse.osgi_3.13.200.v20181130-2106
1	RESOLVED    unknown_0.0.0 [1]
2	ACTIVE      org.apache.felix.scr_2.1.14
3	RESOLVED    osgi.cmpn_4.3.1.201210102024
4	RESOLVED    osgi.core_4.3.1.201210102023
5	ACTIVE      org.apache.felix.gogo.runtime_1.1.0
6	ACTIVE      org.apache.felix.gogo.shell_1.1.0
7	RESOLVED    org.eclipse.osgi.services_3.7.100.v20180827-1536
8	ACTIVE      org.eclipse.equinox.ds_1.5.200.v20180827-1235
9	RESOLVED    org.jetbrains.kotlin.osgi-bundle_1.3.11
10	ACTIVE      org.apache.felix.gogo.command_1.0.2
11	ACTIVE      org.eclipse.equinox.console_1.3.100.v20180827-1235
13	RESOLVED    org.osgi.kt.examples.console_0.1.0.SNAPSHOT
```

The code of this project is shipped inside the `org.osgi.kt.example.console` bundle. As you can see, it has not been 
started yet. To start the bundle enter the command `start <id>` where `<id>` is the id of the `org.osgi.kt.example.console` 
bundle. When the bundle is started, its service component will immediately activated, which will trigger the execution 
of the `@Activate` annotated method. The result should be similar to this output:

```bash
g! start 13
Hello OSGi
Here's Kotlin
```



