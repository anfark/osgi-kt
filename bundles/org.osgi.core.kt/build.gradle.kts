import aQute.bnd.gradle.FileSetRepositoryConvention
import aQute.bnd.gradle.TestOSGi
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

version = "7.0-SNAPSHOT"


dependencies {
    compile(kotlin("stdlib"))
    compile("org.osgi:osgi.core:7.0.0")

    testImplementation("net.oddpoet:kotlin-expect:1.2.1")
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:+")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:+")
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


tasks.create<TestOSGi>("testBundle") {
    setBndrun("test.bndrun")

    /*
    withConvention(FileSetRepositoryConvention::class) {
        bundles()
    }
    */
}

// Enable Spek
extensions.getByType(JUnitPlatformExtension::class.java).apply {
    filters {
        engines {
            include("spek2")
        }
    }
}
