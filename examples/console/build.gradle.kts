group = "org.osgi.kt.examples"
version = "0.1.0-SNAPSHOT"
val symbolicName = "org.osgi.kt.examples.console"

plugins {
    // Needed to compile Kotlin
    kotlin("jvm") version "1.3.11"

    // Needed to create OSGi bundle
    id("biz.aQute.bnd.builder") version "4.1.0"
}

repositories {
    mavenCentral()
}

dependencies {
    // Core runtime with console
    archives("org.eclipse.platform:org.eclipse.osgi:3.13.200")
    archives("org.eclipse.platform", "org.eclipse.osgi", "3.13.100")
    archives("org.eclipse.platform", "org.eclipse.equinox.console", "1.3.100")
    archives("org.apache.felix", "org.apache.felix.gogo.command", "1.0.2")


    // Provides Kotlin during runtime
    archives(kotlin("osgi-bundle"))

    // Enable DS annotations
    archives("org.eclipse.platform:org.eclipse.equinox.ds:1.5.200")
    archives("org.eclipse.platform:org.eclipse.osgi.services:3.7.100")

    // Only needed during coding
    compile(kotlin("stdlib"))
    compile("org.osgi:osgi.cmpn:6.0.0")
}

val dest = "build/app"

// Copy the bundles into the plugin folder
tasks.create<Copy>("copyBundles") {
    group = "help"

    from(configurations["archives"])
    into(dest)

    // Strip version number from name
    rename {
        it.substringBeforeLast("-") + ".jar"
    }
}


// Creates a configuration file for equinox
tasks.create<WriteProperties>("writeConfig") {
    group = "help"
    outputFile = file("$dest/configuration/config.ini")

    // Names of the bundles which should be started with equinox
    val startBundles = setOf(
        "org.apache.felix.gogo.command",
        "org.apache.felix.gogo.runtime",
        "org.apache.felix.gogo.shell",
        "org.eclipse.equinox.console",
        "org.eclipse.equinox.ds")

    val bundles = configurations["archives"].resolvedConfiguration.resolvedArtifacts
        .map { it.name + if (startBundles.contains(it.name)) "@start" else "" }
        .reduceIndexed { index, bundle, acc -> if (index == 0) bundle else "$acc, $bundle" }


    property("osgi.bundles", "$bundles, $symbolicName")
    property("equinox.use.ds", true)
    property("osgi.noShutdown", true)
    property("eclipse.ignoreApp", true)
}

// Copy the configuration file into the final application
tasks.create<Copy>("copyConfig") {
    group = "help"

    from(file("config.ini"))
    into(file("$dest/configuration/"))
}

// Configure build task
tasks {
    // Configure Build Task
    "build" {
        dependsOn("copyBundles")
        dependsOn("writeConfig")
    }

    "jar"(Jar::class) {
        dependsOn("copyBundles")


        destinationDir = file("build/app")
        archiveName = "$symbolicName.jar"

        manifest {
            attributes["Bundle-SymbolicName"] = symbolicName
            attributes["Bundle-Name"] = "Hello Console"
        }
    }
}

