package org.osgi.framework.kt

import org.osgi.framework.Bundle
import org.osgi.framework.FrameworkUtil
import kotlin.reflect.KClass

/**
 * @return the bundle containing the given class.
 */
inline fun bundle(classFromBundle: Class<*>) = FrameworkUtil.getBundle(classFromBundle)

/**
 * @return the bundle containing this class.
 */
inline val Class<*>.bundle: Bundle
    get() = FrameworkUtil.getBundle(this)

/**
 * @return the bundle containing this class.
 */
inline val KClass<*>.bundle: Bundle
    get() = FrameworkUtil.getBundle(this.java)

/**
 * @return the headers of this bundle as {Map}
 */
inline val Bundle.headersMap: Map<String, String>
    get() = headers.keys().toList().map { it to headers[it] }.toMap()
