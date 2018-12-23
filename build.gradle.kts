import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    base
    kotlin("jvm") version "1.3.11" apply false
    id("biz.aQute.bnd.builder") version "4.1.0"
}

version = "1.0-SNAPSHOT"

// Genereal setup for every project (including this one)
allprojects {
    // Set default group and version
    group = "org.osgi.kt"

    // Set jvm target to 1.8
    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}

// Configure subprojects
subprojects {
    // Setup default repositories
    repositories {
        mavenCentral()
    }

    // Check if this is a bundle project
    if (this.projectDir.parent.endsWith("bundles")) {
        // Applies the kotlin and bnd plugin to every bundle project
        apply {
            plugin("org.jetbrains.kotlin.jvm")
            plugin("biz.aQute.bnd.builder")
        }
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "4.10.3"
}