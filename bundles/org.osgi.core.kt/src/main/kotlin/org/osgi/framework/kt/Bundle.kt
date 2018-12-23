package org.osgi.framework.kt

import org.osgi.framework.Bundle
import org.osgi.framework.BundleActivator
import org.osgi.framework.Constants
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

/**
 * The name of the bundle resource class that implements the {BundleActivator} interface and whose {BundleActivator#start} and {BundleActivator#stop} methods
 * are called by the Framework when the bundle is started and stopped, respectively.
 */
inline var Bundle.activator: String?
    get() = headers[Constants.BUNDLE_ACTIVATOR]
    set(value) { headers.put(Constants.BUNDLE_ACTIVATOR, value)}


/**
 *  The activation policy of this {Bundle}.
 */
inline val Bundle.activationPolicy: String?
    get() = headers[Constants.BUNDLE_ACTIVATIONPOLICY]

/**
 * Checks if the activation policiy of this bundle is lazy.
 */
inline val Bundle.isLazy: Boolean
    get() = activationPolicy == Constants.ACTIVATION_LAZY
