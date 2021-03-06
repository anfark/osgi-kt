import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    base
    kotlin("jvm") version "1.3.11" apply false
    id("biz.aQute.bnd.builder") version "4.1.0" apply false
}

version = "1.0-SNAPSHOT"


// General setup
allprojects {
    // Set default group
    group = "org.osgi.kt.examples.quickstart"

    // Set jvm target to 1.8
    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}

subprojects {
    // Enable BND and Kotlin in subprojects
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("biz.aQute.bnd.builder")
    }

    // Add default repository
    repositories {
        mavenCentral()
    }
}