import aQute.bnd.gradle.Export
import aQute.bnd.gradle.Index
import aQute.bnd.gradle.Resolve
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    id("biz.aQute.bnd.builder")
}

version = "7.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compile(project(":rest"))//org.osgi.kt.examples.quickstart.rest"))

    compile(kotlin("osgi-bundle"))
    compile("org.osgi.enroute:impl-index:+")
    compile("org.osgi.enroute:debug-bundles:+")
}

tasks.create<Copy>("copyDependencies") {
    from(configurations["compile"])
    into(file("build/libs"))
}


tasks {
    "jar"(Jar::class) {
        manifest {
            attributes["Bundle-SymbolicName"] = "org.osgi.kt.examples.quickstart.app"
            attributes["Bundle-Name"] = "OSGi.kt Example Quickstart App"
        }
    }

    "build" {
        dependsOn("copyDependencies")
    }
}

tasks.create<Index>("index") {
    dependsOn("build")

    setBundles(fileTree("build/libs") {
        include("**/*.jar")
        exclude("**/*-source.jar")
    })

    setDestinationDir("build/libs")
    isGzip = false
    indexName = "index.xml"

}

tasks.create<Export>("export") {
    dependsOn("resolve")
    setBndrun(file("app.bndrun"))
    setDestinationDir("build/export")
}

tasks.create<Resolve>("resolve") {
    dependsOn("index")
    setBndrun(file("app.bndrun"))
}

tasks.create<Resolve>("resolve-debug") {
    dependsOn("index")
    setBndrun(file("debug.bndrun"))
}