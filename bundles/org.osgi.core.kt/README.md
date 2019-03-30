# OSGi.kt Core API
Symbolic Name: `org.osgi.core.kt`

## What

This submodule contains Kotlin extensions for the OSGi Core API.

## Why

See the [description](../README.md) of the root project for a motivation.

## How

### Bundles

In OSGi bundles can be obtained via a static method of `FrameworkUtil`. In Kotlin it is more common to use a gloabl function
or a extension property instead.

```kotlin
// Get the bundle containing the class of MyObject
var b = MyObject::class.bundle
b = MyObject::class.java.bundle

// Alternative: global method
b = bundle(MyObject::class)
```

This bundle also introduces getter methods for all bundle attribute headers defined in OSGi.

```kotlin
val bundle: Bundle = ...

bundle.description // The value of the "Bundle-Description" attribute or null if not set
bundle.name // The value of the "Bundle-Name" attribute or null if not set
//etc
```
