package org.osgi.service.event

import org.osgi.framework.BundleContext
import java.util.*


inline fun BundleContext.on(topics: Array<String>, properties: Map<String, String> = mapOf(), crossinline handler: (Event) -> Unit) {
    val ht = Hashtable<String, Any>()
    ht[EventConstants.EVENT_TOPIC] = topics

    properties.forEach { key, value -> ht[key] = value }

    this.registerService(EventHandler::class.java.name, object: EventHandler {
        override fun handleEvent(event: Event) {
            handler(event)
        }
    }, ht)
}

inline fun BundleContext.on(topic: String, properties: Map<String, String> = mapOf(), crossinline handler: (Event) -> Unit) {
    on(arrayOf(topic), properties, handler)
}


inline fun <reified E> BundleContext.on(topic: String, crossinline handler: (E) -> Unit) {
    on(topic) {
        if (it is E) {
            handler(it)
        }
    }
}