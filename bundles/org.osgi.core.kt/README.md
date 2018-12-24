# OSGi.kt Core API

## What

This submodule contains the content of 

## Why
See the description of the root project for a motivation.

## How

This bundles introduces some extensions to bring the power of Kotlin to OSGi. Most of the extensions are inline functions
or getter which only cover the call of static util methods.

### Bundles

In OSGi bundles can be obtained via a static method of `FrameworkUtil`. With the Kotlin wrapper, new ways to get a bundle are introduced.

```kotlin
// Get bundle that contains the class of MyObject
var b = MyObject::class.bundle
b = MyObject::class.java.bundle

// Alternative: global method
b = bundle(MyObject::class)

```