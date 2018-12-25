package org.osgi.kt.examples.console

import org.osgi.service.component.annotations.*

@Component(immediate = true)
class Hello {

    @Activate
    fun activate() {
        listOf("Hello OSGi", "Here's Kotlin").forEach {
            println(it)
        }
    }
}