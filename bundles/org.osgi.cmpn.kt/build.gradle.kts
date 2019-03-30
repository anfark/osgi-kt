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


dependencies {
    compile(kotlin("stdlib"))
    compile(project(":org.osgi.core.kt"))
    compile("org.osgi:osgi.cmpn:7.0.0")

    testImplementation("net.oddpoet:kotlin-expect:1.2.1")
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:${spekVersion}")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:${spekVersion}")
    testRuntimeOnly(kotlin("reflect"))
}

tasks {
    "jar"(Jar::class) {
        manifest {
            attributes["Bundle-SymbolicName"] = "org.osgi.cmpn.kt"
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
