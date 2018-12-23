rootProject.name = "org.osgi.kt"

includeBundle("org.osgi.core.kt")

// Includes a projects from the bundles folder and sets the name.
fun includeBundle(name: String) {
    include("bundles/$name")
    project(":bundles/$name").name = name
}
