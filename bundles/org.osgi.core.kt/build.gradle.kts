import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.junit.platform.gradle.plugin.JUnitPlatformExtension


buildscript {
    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath("org.junit.platform:junit-platform-gradle-plugin:1.0.1")
    }
}

apply {
    plugin("org.junit.platform.gradle.plugin")
}


val spekVersion = "+"

version = "7.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://dl.bintray.com/spekframework/spek-dev")
    }
}

dependencies {
    compile(kotlin("stdlib"))
    compile("org.osgi:osgi.core:7.0.0")

    testImplementation("org.spekframework.spek2:spek-dsl-jvm:${spekVersion}")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:${spekVersion}")
    testRuntimeOnly(kotlin("reflect"))
}

tasks {
    "jar"(Jar::class) {
        manifest {
            attributes["Bundle-SymbolicName"] = "org.osgi.core.kt"
            attributes["Bundle-Name"] = "OSGi Core Kotlin API"
        }
    }
}


// Enable Spek
extensions.getByType(JUnitPlatformExtension::class.java).apply {
    filters {
        engines {
            include("spek2")
        }
    }
}
