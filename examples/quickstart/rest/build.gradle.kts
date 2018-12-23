import aQute.bnd.gradle.BundleTaskConvention
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
    compile(kotlin("stdlib"))

    // OSGi-API
    compile(osgi("core", "7.0.0"))
    compile(osgi("cmpn", "7.0.0"))
    compile(osgi("annotation", "7.0.0"))

    // Enterprise-API
    compile("org.apache.aries.jpa.javax.persistence:javax.persistence_2.1:2.7.0")
    compile("org.apache.aries.spec:org.apache.aries.javax.jax.rs-api:1.0.0")
    compile("org.apache.felix:org.apache.felix.http.servlet-api:1.1.2")

    // Test-Bundles
    testCompile("org.apache.servicemix.bundles:org.apache.servicemix.bundles.junit:4.12_1")
    testCompile("org.mockito:mockito-core:2.13.0")
}

tasks {
    "jar"(Jar::class) {
        manifest {
            attributes["Bundle-SymbolicName"] = "org.osgi.kt.examples.quickstart.rest"
            attributes["Bundle-Name"] = "OSGi.kt Example Quickstart REST"
        }
    }
}

fun DependencyHandler.osgi(module: String, version: String? = null): Any =
    "org.osgi:osgi.$module${version?.let { ":$version" } ?: ""}"